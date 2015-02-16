
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Nick and Justin
 */
public class Server 
{
    ArrayList<ServerClient> clients = new ArrayList();
    
    boolean gameInProgress, running;
    private int port; 
    private ServerSocket server;
    
    public Server(int port)
    {
        this.port = port;
    }
    
    public void start()
    {
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
                
            }
        }
    }
}
