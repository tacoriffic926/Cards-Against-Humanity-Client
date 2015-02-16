import CAH_Cards.*;
import java.util.ArrayList;
/**
 *
 * @author Nick and Justin
 */
public class Test 
{
    public static void main(String[] args)
    {
        ArrayList<String> packsUsed = new ArrayList<>();
        packsUsed.add("ExampleCardPack.txt");
        packsUsed.add("ExampleCardPack2.txt");
        Card.createCardPack(packsUsed);
        
        Server server = new Server(1996);
        server.start();
    }
}
