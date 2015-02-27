
import CAH_Cards.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick and Justin
 */
public class Client implements ActionListener
{
    int port;
    String ip, name;
    private Socket server;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    boolean gameInProgress, running;
    
    public Client(String ip, int port, String name)
    {
        this.ip = ip;
        this.port = port;
        this.name = name;
    }
    
    public void start()
    {
        try {
            server = new Socket(InetAddress.getByName(ip), port);
            in = new ObjectInputStream(server.getInputStream());
            out = new ObjectOutputStream(server.getOutputStream());
        } catch (IOException ex) {
            System.err.println(ex);
        }
        BlackCard b = new BlackCard("hi :1");
        try {
            out.writeObject(b);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        running = true;
        run();
    }
    
    private void run()
    {
        while(running)
        {
            while(!gameInProgress)
            {
                
            }
            
            while(gameInProgress)
            {
                
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("woot"); //To change body of generated methods, choose Tools | Templates.
    }
    
}