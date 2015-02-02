
package CAH_Cards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick and Justin
 */
public abstract class Card 
{
    ArrayList<String> backcardArray = new ArrayList<>();
    ArrayList<String> whitecardArray = new ArrayList<>();
    
    
    public static void createCardPack(String filePath)
    {
        Scanner scan = null;
        ArrayList<String> cardTxt = new ArrayList<>();
        try {
            FileInputStream fileStream = new FileInputStream(filePath);
            scan = new Scanner(fileStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(scan.hasNext())
            cardTxt.add(scan.nextLine());
        
        System.out.println(cardTxt);
        
    }
}
