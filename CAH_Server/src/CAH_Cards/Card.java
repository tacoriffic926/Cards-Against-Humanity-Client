
package CAH_Cards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick and Justin
 */
public class Card implements Serializable
{
    ArrayList<BlackCard> blackCards = new ArrayList<>();
    ArrayList<WhiteCard> whiteCards = new ArrayList<>();
    
    public String txt;
    
    public void createCardPack(ArrayList<String> filePath)
    {
        Scanner scan = null;
        ArrayList<String> cardTxt = new ArrayList<>();
        for (int i=0;i<filePath.size();i++)
        {
            try {
                FileInputStream fileStream = new FileInputStream(filePath.get(i));
                scan = new Scanner(fileStream);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            while(scan.hasNext())
                cardTxt.add(scan.nextLine());
        }
//        System.out.println(cardTxt);
        for(String txt : cardTxt)
        {
            if(txt.charAt(0) == '~')         //Black
            {
                blackCards.add(new BlackCard(txt.substring(1)));
            }
            else if(txt.charAt(0) == '`')    //White
            {
                whiteCards.add(new WhiteCard(txt.substring(1)));
            }
        }
        
    }
}
