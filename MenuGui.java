import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.*;
import javax.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class MenuGui	extends JFrame	implements ActionListener{
		 
	private JLabel	title, background, helpText;
	private JFrame	main,	helpScreen;
	private JPanel	screen,buttons,helpPanel;
	private JButton play,help,exit;
	private JFrame	about;
		
	public MenuGui(){
   	JFrame main	= new	JFrame();
   	main.setSize(1000,1000);
   	main.setLocationRelativeTo(null);
   	main.setLayout(null);
   	
   	JPanel screen = new JPanel();
   	
   	play = new JButton("Play Game!");
   	play.setFont(new Font("arial", Font.BOLD,	30));
   	play.addActionListener(this);
   	play.setSize(300,75);
   	play.setLocation(350,350);
   	
   	help = new JButton("How to Play");
   	help.addActionListener(this);
   	help.setFont(new Font("arial", Font.BOLD,	30));
   	help.setSize(300,75);
   	help.setLocation(350,450);
   	
   	exit = new JButton("Quit Game");
   	exit.addActionListener(this);
   	exit.setFont(new Font("arial", Font.BOLD,	30));
   	exit.setSize(300,75);
   	exit.setLocation(350,550);
   	
   	background = new JLabel(new ImageIcon("battleship_background.png"));//LOOKIT IT'S PRETTY
   	background.setSize(1000,1000);
   	background.setLocation(0,0);
   		
   	main.add(help);
   	main.add(play);
   	main.add(exit);
   	main.add(background);
   	
   	main.revalidate();
   	main.repaint();
   	main.setVisible(true);
     
   	main.setResizable(false);
   	
   	main.setDefaultCloseOperation(EXIT_ON_CLOSE);
   	main.validate();
   	main.repaint();
   	
   	helpScreen = new JFrame();
      helpScreen.setLayout(null);
   	helpScreen.setSize(1000,1000);
      helpScreen.getContentPane().setBackground(new Color(250, 220, 150));
      
      // JPanel helpPanel = new JPanel();
//       helpPanel.setOpaque(false);
//       helpPanel.setSize(1000,1000);
//       helpPanel.setLocation(0,0);
      
      
      
   	helpText	= new	JLabel("test bla bla blabla bla bal abl abl ab");
      helpText.setBackground(Color.WHITE);
      helpText.setSize(500,50);
      helpText.setOpaque(true);      
      helpText.setLocation(250,300);
      
   	//helpPanel.add(helpText);
      //helpScreen.add(helpText);  
      helpScreen.add(helpText);
	}
	public void	actionPerformed(ActionEvent e){
		if(e.getSource() == play){
			MainGui game =	new MainGui();
         game.setLocationRelativeTo(null);
			game.setVisible(true);
         
		}
		if(e.getSource() == help){			  
			helpScreen.setVisible(true);
         helpScreen.setLocationRelativeTo(null);		 
		}
      if(e.getSource() == exit){
         System.exit(0);
      }
	}
   
	public static void main(String[]	args){
		MenuGui menu =	new MenuGui();
	}
}