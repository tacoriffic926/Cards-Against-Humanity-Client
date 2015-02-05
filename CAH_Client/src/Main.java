
/**
 *
 * @author Justin
 */
public class Main {
public static void main(String args[])
{    
WorkFrame wf1 = new WorkFrame(1920,1040);
WorkPanel wp1= new WorkPanel(1920,1040);
//WorkPanel wp2= new WorkPanel(170,50);
wf1.getContentPane().add(wp1);
wf1.setVisible(true);
//wp1.paint();
//wp1.initGraphShapes(5,5);
//wp1.AnimateGraphShapes();

}    
}
