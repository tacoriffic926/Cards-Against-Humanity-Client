
import java.awt.Color;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justin
 */

public class WorkFrame extends JFrame {
public WorkFrame(int x,int y)
{
super("Gotta Go Fast");
setSize(x, y);
//getContentPane().setBackground(Color.BLACK);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
}
}
