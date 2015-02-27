
import CAH_Cards.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 *
 * @author Nick and Justin
 */

public class Server extends JFrame implements ActionListener
{
    ArrayList<ServerClient> clients = new ArrayList();
    
    boolean gameInProgress, running;
    private int port; 
    private ServerSocket server;
    private JTextArea output;
    private JTextField cmdLine;
    private Font font = new Font("Helvetica", Font.BOLD, 12);
    Random rand = new Random();
    Card cards = new Card();
    ArrayList<String> cardPacks = new ArrayList();
    
    public Server(int port)
    {
        this.port = port;
        
        cmdLine = new JTextField();
        cmdLine.setFont(font);
        cmdLine.setBackground(Color.black);
        cmdLine.setForeground(Color.white);
        cmdLine.addActionListener(this);
        add(cmdLine, BorderLayout.SOUTH);
        
        output = new JTextArea();
        output.setFont(font);
        output.setBackground(Color.black);
        output.setForeground(Color.white);
        output.setEditable(false);
        add(new JScrollPane(output));
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public void startServer()
    {
        setVisible(true);
        try 
        {
            server = new ServerSocket(port);
            running = true;
        } 
        catch (IOException ex) 
        {
            System.out.println("Failed to create server on port: " + port);
        }
        try {
            server.setSoTimeout(500);
        } catch (SocketException ex) {
            System.err.println("Failed to set Timeout");
        }
        run();
    }
    
    private void run()
    {
        ServerClient newClient;
        Thread t;
        while(running)
        {
            while(!gameInProgress)  //Check for connections, Pick Card Packs, etc...
            {
                if(!running)
                    break;
                try 
                {
                    newClient = new ServerClient(server.accept(), this);
                    clients.add(newClient);
                    if(clients.size() == 1)
                        newClient.setHost(true);
                    t = new Thread(newClient);
                    t.start();
                    
                }
                catch (IOException ex) 
                {
                    //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            while(gameInProgress) //Game Logic & Stuff
            {
                if(!running)
                    break;
                
            }
        }
    }
    
    private void startGame()
    {
       gameInProgress = true;
       clients.get(rand.nextInt(clients.size())).setCzar(true);
    }
    
    private void nextCzar()
    {
        int index = 0;
        for(int i = 0; i < clients.size(); i++)
            if(clients.get(i).czar)
            {
                index = i+1;
                clients.get(i).setCzar(false);
                break;
            }
        
        if(index == clients.size())
            index = 0;
        
        clients.get(index).setCzar(true);
    }
    
    private void setHost(String name)
    {
        boolean found = false;
        for(ServerClient client : clients)
            if(name.equals(client.name))
            {
                client.setHost(true);
                found = true;
            }
        
        if(found)
            for(ServerClient client : clients)
                if(client.host)
                    client.setHost(false);
        
        if(!found)
            output.append("player not found!\n");
    }
    
    boolean checkName(String name)
    {
        boolean found = false;
        for(ServerClient client : clients)
            if(name.equals(client.name))
                found = true;
        return found;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        if(!command.equals(""))
        {
            if(command.charAt(0) == '/')
            {
                if(command.startsWith("/stop")) //stops server
                {
//                    stop();
                }
                else if(command.startsWith("/start")) //starts game
                {
                    startGame();
                }
                else if(command.startsWith("/moveOn")) //stop waiting for cards and gives current white cards to czar
                {
                    
                }
                else if(command.startsWith("/kick")) //kicks player
                {
                    
                }
                else if(command.startsWith("/endGame")) //ends game returns to lobby
                {
                    
                }
                else if(command.startsWith("/addCardPack ")) //add a card pack
                {
                    cardPacks.add(command.substring(13));
                }
                else if(command.startsWith("/setBlanks")) //sets nummber of blank cards
                {
                    
                }
                else if(command.startsWith("/removeCardPack ")) //removes a card pack
                {
                    cardPacks.remove(command.substring(16));
                }
                else if(command.startsWith("/printClients")) //prints connected clients
                {
//                    output.append(clients.get(0).toString());
                }
                else if(command.startsWith("/printCardPacks")) //prints card packs
                {
                    output.append(cardPacks + "\n");
                }
                else if(command.startsWith("/setHost ")) //*** if we have a host *** sets host
                {
                    command = command.substring(9);
                    setHost(command);
                }
                else if(command.startsWith("/printBlackCard")) //prints current black card in play
                {
                    
                }
                else if(command.startsWith("/printWhiteCards")) //prints white cards in play
                {
                    
                }
                else if(command.startsWith("/message")) //messages clients
                {
                    
                }
                
            }
            else
            {
                output.append(command + "\n");
            }
            cmdLine.setText("");
        }
    }
}
