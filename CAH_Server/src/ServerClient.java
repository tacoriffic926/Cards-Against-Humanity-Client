
import CAH_Cards.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    String name;
    boolean czar, host;
    
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
            System.err.println("Failed to set up input and output streams");
        }
    }

    @Override
    public void run()
    {
        System.out.println("connected and started");
//        while(true)
//        {
//            Object obj = null;
//            BlackCard b;
//            try {
//                obj = in.readObject();
//            } catch (IOException ex) {
//                Logger.getLogger(ServerClient.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(ServerClient.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            if(obj instanceof BlackCard)
//            {
//                b = (BlackCard) obj;
//                System.out.println(b.txt);
//                System.out.println(b.nbrOfRequiredCards);
//            }
//        }
    }
    
    private void setName(String name)
    {
        this.name = name;
    }
    
    void setCzar(boolean bool)
    {
        czar = bool;
    }
    
    void setHost(boolean bool)
    {
        host = bool;
    }
    
    void displayBlackCard(BlackCard card)
    {
        try {
            out.writeObject(card);
        } catch (IOException ex) {
            Logger.getLogger(ServerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void sendWhiteCards(WhiteCard[] cards)
    {
        try {
            out.writeObject(cards);
        } catch (IOException ex) {
            Logger.getLogger(ServerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String toString()
    {
        return "Name: " + name + "\n\tHost: " + host + "\n\tCzar: " + czar + "\n";
    }
}
