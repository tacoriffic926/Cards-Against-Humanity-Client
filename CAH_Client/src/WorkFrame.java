
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Nick and Justin
 */

public class WorkFrame extends JFrame 
{
    public WorkFrame(int x,int y)
    {
        super("Gotta Go Fast");
        setSize(x, y);
        //getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }
}
