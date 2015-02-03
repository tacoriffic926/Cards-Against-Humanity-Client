
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 *
 * @author Nick and Justin
 */
public class ServerClient implements Runnable
{
    Server server;
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    
    public ServerClient(Socket socket, Server server)
    {
        this.socket = socket;
        this.server = server;
        
        try 
        {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException ex) 
        {
            System.out.println("Failed to set up input and output streams");
        }
    }

    @Override
    public void run()
    {
        
    }
}
