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
   private JPanel screen,buttons;
   private JButton play,help;
   private JFrame about;
      
	public MenuGui(){
   
   JPanel screen = new JPanel();
   screen.setLayout(null);
   screen.setSize(WIDTH,HEIGHT);
   screen.setLocation(0,0);
   
   play = new JButton("Play Game!");
   play.addActionListener(this);
   play.setSize(250,50);
   play.setLocation(375,400);
   
   help = new JButton("How to Play");
   help.addActionListener(this);
   help.setSize(250,50);
   help.setLocation(375,500);
   
   background = new JLabel(new ImageIcon("battleship_background.png"));//LOOKIT IT'S PRETTY
   background.setSize(1000,1000);
   background.setLocation(0,0);
   screen.add(background);
   //buttons.add(play);
   //buttons.add(help);
   screen.add(play);
   screen.add(help);
   //screen.add(buttons, BorderLayout.CENTER);
   screen.revalidate();
   screen.repaint();
   add(screen);
  
      
   //setMinimumSize(new Dimension(WIDTH,HEIGHT));
   //setMaximumSize(new Dimension(WIDTH,HEIGHT));
   //setPreferredSize(new Dimension(WIDTH,HEIGHT));
   setSize(WIDTH,HEIGHT);
   setResizable(false);
   setVisible(true);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   validate();
   //this.repaint();
   
   helpScreen = new JFrame();
   helpScreen.setSize(WIDTH, HEIGHT);
   helpText = new JLabel("test");
   helpScreen.add(helpText);
   //screen.add(helpScreen);
	}
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == play){
         MainGui game = new MainGui();
         game.setVisible(true);
      }
      if(e.getSource() == help){         
         helpScreen.setVisible(true);         
      }
   }
   
   public static void main(String[] args){
      MenuGui menu = new MenuGui();
   }
}