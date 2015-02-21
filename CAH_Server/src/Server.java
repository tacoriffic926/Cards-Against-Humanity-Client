
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
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
    
    public void start()
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
                    t = new Thread(newClient);
                    t.start();
                    
                }
                catch (IOException ex) 
                {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            while(gameInProgress) //Game Logic & Stuff
            {
                if(!running)
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        if(!command.equals(""))
        {
            if(command.charAt(0) == '/')
            {
                if(e.getActionCommand().equals("/stop"))
                {
                    output.append("Server Shutting Down\n");
                    running = false;
//                    stop();
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
