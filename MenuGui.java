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

   JPanel screen = new JPanel();
   screen.setLayout(null);
   screen.setSize(WIDTH,HEIGHT);
   screen.setLocation(0,0);
   screen.setBackground(new Color(115, 185, 105));
   
   buttons = new JPanel();
   buttons.setLocation(250,250);
   buttons.setSize(500,500);
   buttons.setLayout(null);
   
   play = new JButton("Play Game!");
   play.addActionListener(this);
   play.setSize(250,50);
   play.setLocation(125,200);
   
   help = new JButton("How to Play");
   help.addActionListener(this);
   help.setSize(250,50);
   help.setLocation(125,280);
   
   buttons.add(play);
   buttons.add(help);
   
   screen.add(buttons, BorderLayout.CENTER);
   add(screen);
  
      
   //setMinimumSize(new Dimension(WIDTH,HEIGHT));
   //setMaximumSize(new Dimension(WIDTH,HEIGHT));
   //setPreferredSize(new Dimension(WIDTH,HEIGHT));
   setSize(WIDTH,HEIGHT);
   setResizable(false);
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