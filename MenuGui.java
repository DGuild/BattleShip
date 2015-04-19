import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.*;
import javax.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class MenuGui	extends JFrame	implements ActionListener{
	private static	final	int WIDTH =	1000;
	private static	final	int HEIGHT = 1000;
	final	Toolkit toolkit =	Toolkit.getDefaultToolkit();
	final	Dimension screenSize	= toolkit.getScreenSize();
	final	int x	= (screenSize.width - this.getWidth())	/ 2;
	final	int y	= (screenSize.height	- this.getHeight()) / 2;
	 
	private JLabel	title, background, helpText;
	private JFrame	main,	helpScreen;
	private JPanel	screen,buttons;
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
   	helpScreen.setSize(WIDTH, HEIGHT);
   	helpText	= new	JLabel("test");
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