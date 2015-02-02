
package CAH_Cards;

import java.util.ArrayList;

/**
 *
 * @author Nick and Justin
 */
public class BlackCard extends Card
{
    int nbrOfRequiredCards;
    
    public BlackCard(String txt)
    {
        String[] splitTxt = txt.split(" :");
        this.txt = splitTxt[0];
        nbrOfRequiredCards = Integer.parseInt(splitTxt[1]);
    }
}
