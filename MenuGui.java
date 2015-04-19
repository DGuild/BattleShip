import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.*;
import javax.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class MenuGui	extends JFrame implements ActionListener{
	private static	final	int WIDTH =	1000;
	private static	final	int HEIGHT = 1000;
	
   private JLabel title, background, helpText;
   private JFrame main, helpScreen;
   private JPanel screen,buttons;//,helpScreen;
   private JButton play,help;
   private JFrame about;
   
	public MenuGui(){
   
  //  JPanel screen = new JPanel();
//    LayoutManager overlay = new OverlayLayout(screen);
//    screen.setLayout(overlay);
//    
//    JPanel bg = new JPanel(new FlowLayout());
//    background = new JLabel(new ImageIcon("battleship_background.png"));//LOOKIT IT'S PRETTY
//    
//    bg.add(background, BorderLayout.CENTER);
//    screen.add(bg);
//    add(screen, BorderLayout.CENTER);
//    
//    buttons = new JPanel();   
//    play = new JButton("Play Game!");
//    help = new JButton("How to Play");
//    
//    
//    buttons.add(play);
//    
//    buttons.add(help);
//    
//    
//    screen.add(buttons);

   JPanel screen = new JPanel(new BorderLayout());
   buttons = new JPanel();
   buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
   play = new JButton("Play Game!");
   play.addActionListener(this);
   help = new JButton("How to Play");
   help.addActionListener(this);
   
   buttons.add(play);
   buttons.add(help);
   
   screen.add(buttons, BorderLayout.CENTER);
   add(screen);
  
      
   setSize(WIDTH, HEIGHT);
   setVisible(true);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   
   helpScreen = new JFrame();
   helpScreen.setSize(WIDTH, HEIGHT);
   helpText = new JLabel("test");
   helpScreen.add(helpText);
   //screen.add(helpScreen);
	}
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == play){
         //MainGui game = new MainGui();
         //game.setVisible(true);
      }
      if(e.getSource() == help){         
         helpScreen.setVisible(true);         
      }
   }
   
   public static void main(String[] args){
      MenuGui menu = new MenuGui();
   }
}