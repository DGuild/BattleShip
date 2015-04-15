import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.*;
import javax.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class MainGui extends JFrame{
   int shipnum= -1;
   int rotationNum=0;
   private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    
    private JLabel title, hShipLabel,cShipLabel, pshipYard, cshipYard;
    private JTextField lengthTF, widthTF, areaTF, perimeterTF;
    private JButton calculateB, exitB;
    private Grid board = new Grid();
    //Player player= new Player();
    ComputerPlayer computer= new ComputerPlayer();
   // private BufferedImage myPicture;
    Fleet fleet= new Fleet();
    
     //picture
       public MainGui(){
        title = new JLabel("Begin Battleship!", SwingConstants.CENTER);
        hShipLabel = new JLabel("Player Ships", SwingConstants.CENTER);
        cShipLabel = new JLabel("Computer Ships", SwingConstants.CENTER);
        //gameBoard= new JLabel("",SwingConstants.RIGHT);
        //various counters need to show how many ships for each side
        pshipYard= new JLabel();
        cshipYard= new JLabel("ShipYard");
        lengthTF = new JTextField(10);
        widthTF = new JTextField(10);
        areaTF = new JTextField(10);
         
        //Buttons too:
        calculateB = new JButton("");
        exitB = new JButton("Exit");
        
        //Set the window's title.
        setTitle("Battleship.exe");
         
        //Get the content pane (CP).
        Container pane = getContentPane();
        JPanel grid= new JPanel();
        //Set the layout.
        //paint a grid for the battleship bit
        //Image background = Toolkit.getDefaultToolkit().createImage("background.png");
                //paintComponent(gameBoard);
                //set up game board
        pane.setLayout(new GridLayout(3, 3));
        grid.setLayout(new GridLayout(10,10));
        ImageIcon image2 = new ImageIcon("shipSection.png");
        ImageIcon image3 = resizeImage(image2);
        for(int i=0; i<100; i++){
         JLabel tile = new JLabel(image3);
         grid.add(tile);
        }

        //set up shipyard
        JPanel shipstuff= new JPanel();
        shipstuff.setLayout(new GridLayout(3,1));
        JPanel shipx= new JPanel();
        shipx.setLayout(new GridLayout(1,5));
        JPanel shipy= new JPanel();
        shipy.setLayout(new GridLayout(5,1));
        JPanel buttons= new JPanel();
        buttons.setLayout(new GridLayout(1,2));
        JButton flip= new JButton("Flip");
        JButton next= new JButton("Next");
        buttons.add(flip);
        buttons.add(next);
        Ship[] ships=fleet.returnShip();
        flip.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e)
       {
         if(shipx!=null){
           ImageIcon[] icons= ships[shipnum].getImage();
           //JPanel shipJ= new JPanel();
           //shipJ.setLayout(new GridLayout(1,5));
           int iconNum=0;
           if(rotationNum%2!=0){
              for(int i=0;i<icons.length;i++){
                  ImageIcon newIcon= (icons[iconNum]);
                  newIcon=resizeImage(newIcon);
                  JLabel shipPart= new JLabel(newIcon);
                  
                  shipx.add(shipPart);
                  iconNum++;
                  shipy.removeAll();
              }
              shipx.repaint();
              //shipx.repaint(shipJ);
              shipx.revalidate();
           }else{
              for(int i=0;i<icons.length;i++){
                  ImageIcon newIcon= (icons[iconNum]);
                  newIcon= resizeImage(newIcon);
                  JLabel shipPart= new JLabel(newIcon);
                  shipy.add(shipPart); 
                  iconNum++;
                  shipx.removeAll();
              }
              shipy.repaint();
              //shipx.repaint(shipJ);
              shipy.revalidate();

           }
           iconNum=0;
           shipy.repaint();
           //shipx.repaint(shipJ);
           shipy.revalidate();   
           shipx.repaint();
           shipx.revalidate();
           rotationNum++;
       }
       }
         });
        
          next.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e)
       {
         rotationNum=0;
         shipnum++;
         shipx.repaint();
         shipy.repaint();
         shipx.revalidate();
         shipy.revalidate();
         ImageIcon[] icons= ships[shipnum].getImage();
         int iconNum=0;
          for(int i=0;i<icons.length;i++){
                  ImageIcon newIcon= (icons[iconNum]);
                  newIcon=resizeImage(newIcon);
                  //newicon in here
                  JLabel shipPart= new JLabel(newIcon);
                  shipx.add(shipPart);
                  iconNum++;
              }
          shipx.repaint();
          shipx.revalidate();
       }
         });


        shipstuff.add(shipx);
        shipstuff.add(shipy);
        shipstuff.add(buttons);
        
        //fun stuff
        pane.add(hShipLabel);
        pane.add(title);
        pane.add(cShipLabel);
        pane.add(shipstuff);
        pane.add(grid);
        pane.add(cshipYard);
       // pane.add(areaL);
        pane.add(areaTF);
        pane.add(calculateB);
        pane.add(exitB);
        //gameBoard.drawImage(background, 0, 0, null);
       
  
       setSize(WIDTH, HEIGHT);
       setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);

   }
      public ImageIcon resizeImage(ImageIcon i){
      /*
         Image img = i.getImage();
         //Now create a buffered image the same size as the image:
         BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
         //Then the icon image to the buffered image, and resize it as you do so:
         Graphics g = bi.createGraphics();
         g.drawImage(img, 0, 0, 33, 33, null);
         //(The code above may be incorrect - check the docs)
         //Now recreate the IconImage with the new buffered image:
         ImageIcon newIcon = new ImageIcon(bi);
         return newIcon;
         */
         Image image = i.getImage(); // transform it 
         Image newimg = image.getScaledInstance(33, 33,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
         ImageIcon b= new ImageIcon(newimg);
         return b;
      }
      public ImageIcon overlay(ImageIcon i){
         return i;
      }
      //function to allow ship placement
      /*public void shipPlace(){
         for(
      }*/
       
      public static void main(String[] args){
         MainGui main= new MainGui();
      }
}