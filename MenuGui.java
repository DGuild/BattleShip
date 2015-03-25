import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.*;
import javax.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class MenuGui	extends JFrame{
	private static	final	int WIDTH =	1000;
	private static	final	int HEIGHT = 1000;
	
   private JLabel title, background;
   
	public MenuGui(){
   title = new JLabel("Begin Battleship!", SwingConstants.CENTER);
   
   setLayout(new BorderLayout());
   background=new JLabel(new ImageIcon("battleship_background.png"));//LOOKIT IT'S PRETTY
   add(background);
   background.setLayout(new FlowLayout());
   
   
   //Container pane = getContentPane();
   background.add(title);
   
   setSize(WIDTH, HEIGHT);
   setVisible(true);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
   
   public static void main(String[] args){
      MenuGui menu = new MenuGui();
   }
}