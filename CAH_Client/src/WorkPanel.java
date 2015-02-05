
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justin
 */
public class WorkPanel extends JPanel implements ActionListener {
    
    int x;
    int y;
    public WorkPanel(int x,int y)
    {
    this.x=x;
    this.y=y;
    setBackground(Color.BLACK);
    setSize(x, y);
    setLocation(0,0);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
    super.paintComponent(g);
    
    
    g.setColor(Color.WHITE);
    g.setFont(new Font("Helvetica", Font.BOLD, 50));
    g.drawString("Card Against Humanity",(x/3), 100);
    g.drawString("InDev Client",(x/3)+100, 200);
    JTextField ipInput = new JTextField();  //creates a new jtextfield to put on the jpanel
    ipInput.setSize(200,50);  //sets the size
    ipInput.setVisible(true);  //set it visible
    ipInput.setLocation(x/2-100, y/2-100);
    this.add(ipInput);
    
    }
    public void paint()
    {
    repaint();
    }
    
}
