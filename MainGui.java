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
    JPanel shipStuff;
    Ship[] ships;
    Ship currShip;
    JPanel shipYard;
    Grid grid = new Grid();
    


    
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
        
        //Set the layout.
        //paint a grid for the battleship bit
        //Image background = Toolkit.getDefaultToolkit().createImage("background.png");
                //paintComponent(gameBoard);
                //set up game board
        pane.setLayout(new GridLayout(3, 3));
        
        //Setup the central grid
        JPanel centerGrid= grid.drawGrid();
        
        
        //set up shipyard
        shipStuff = new JPanel();
        ships = fleet.returnShip();
        currShip = ships[0];
        shipYard= drawShip(currShip);
        //The shipyard buttons
        JPanel buttons= new JPanel();
        buttons.setLayout(new GridLayout(1,2));
        JButton flip= new JButton("Flip");
        JButton next= new JButton("Next");
        buttons.add(flip);
        buttons.add(next);
        
        /**
        * FLIP BUTTON ACTION
        */
        flip.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e)
       {
       
         shipStuff.remove(shipYard);
         currShip.rotate();
         shipYard = drawShip(currShip);
         shipStuff.add(shipYard, 0);
         shipStuff.repaint();
         shipStuff.revalidate();
       
       }
         });
        
        
        /**
        * NEXT BUTTON ACTION
        */
       //    next.addActionListener( new ActionListener() {
//        public void actionPerformed(ActionEvent e)
//        {
//          ;
//          });


        //shipstuff.add(shipx);
        //shipstuff.add(shipy);
        shipStuff.add(shipYard);
        shipStuff.add(buttons);
        
        //fun stuff
        pane.add(hShipLabel);
        pane.add(title);
        pane.add(cShipLabel);
        pane.add(shipStuff);
        pane.add(centerGrid);
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
     /* public ImageIcon overlay(ImageIcon j){
         return i;
      }*/
      
      /**
      *  Returns a JPanel to display a ship horizontally or vertically
      */ 
      public JPanel drawShip(Ship s){
         JPanel shipPanel;
         
         //Create a JLabel for either horizontal or vertical orientation
         if(s.isHorizontal()){
            shipPanel = new JPanel(new GridLayout(1, s.getLength()));
         }
         else{
            shipPanel = new JPanel(new GridLayout(s.getLength(), 1));
         }
         
         //Add JLabels for ShipSections
         for(int i = 0; i < s.getLength(); i++){
            ImageIcon shipSectionIcon = new ImageIcon("shipSection.png");
            shipSectionIcon = resizeImage(shipSectionIcon);
            JLabel shipSectionLabel = new JLabel(shipSectionIcon);
            shipPanel.add(shipSectionLabel);
         }
         
         return shipPanel;
      }
      
      //function to allow ship placement
      /*public void shipPlace(){
         for(
      }*/
       
      public static void main(String[] args){
         MainGui main= new MainGui();
      }
}