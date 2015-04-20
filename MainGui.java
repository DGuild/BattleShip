import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.*;
import javax.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MainGui extends JFrame{
   int shipnum= -1;
   int rotationNum=0;
   private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private static final int N = 10;
    private final ArrayList<JButton> list = new ArrayList<JButton>();
    
    private JLabel title, pshipYard;
    private JPanel jp;
    private JTextField output;
    private Grid board = new Grid();
    private boolean setupMode = true;
    //Player player= new Player();
    ComputerPlayer computer= new ComputerPlayer();
   // private BufferedImage myPicture;
    Fleet fleet= new Fleet();
    JPanel shipStuff;
    Ship[] ships;
    int currShipNum;
    Ship currShip;
    JPanel shipYard;
    JPanel centerGrid;
    


    
     //picture
       public MainGui(){
        title = new JLabel("Begin Battleship!", SwingConstants.CENTER);;
        //gameBoard= new JLabel("",SwingConstants.RIGHT);
        //various counters need to show how many ships for each side
        pshipYard= new JLabel();
        output = new JTextField(10);
         
        
        //Set the window's title.
        setTitle("Battleship.exe");
         
        //Get the content pane (CP).
        Container pane = getContentPane();
        
        //Set the layout.
        //paint a grid for the battleship bit
        //Image background = Toolkit.getDefaultToolkit().createImage("background.png");
                //paintComponent(gameBoard);
                //set up game board
        pane.setLayout(new GridLayout(2, 2));
        
        //Setup the central grid
        centerGrid= drawGrid();
        
        
        //set up shipyard
        shipStuff = new JPanel();
        ships = fleet.returnShip();
        currShipNum = 0;
        currShip = ships[currShipNum];
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
        pane.add(output);
        pane.add(title);
        pane.add(shipStuff);
        pane.add(centerGrid);
       // pane.add(areaL);
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
      
      
      /**
      *
      * STUFF FOR THE GRID PANEL
      *
      */
      
      public JPanel drawGrid(){
         jp = new JPanel();
         jp.setLayout(new GridLayout(10,10));
         for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
               JButton l=createGridButton(i,j);
               //ImageIcon icon = grid[i][j].getIcon(); //Get the icon from the gridsquare
               //icon = resizeImage(icon);
               //JButton l = new JButton(icon); //Put the icon on a label
               list.add(l);
               jp.add(l);
            }
         }
         return jp;
      }
      private JButton getGridButton(int r, int c) {
        int index = r * N + c;
        return list.get(index);
      }

      private JButton createGridButton(final int row, final int col) {
        final GridSquare square = board.getGridSquare(row, col);
        ImageIcon icon= square.getIcon();
        icon = resizeImage(icon);
        final JButton b = new JButton(icon);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //JButton gb = Grid.this.getGridButton(row, col);
                //System.out.println("r" + row + ",c" + col);
                
                //OUR STUFF
                //Check if SETUP mode or GAME mode
                if(setupMode){
                  ShipSection[] sections = currShip.getSections();
                  //Check if ship will fit
                  //If it does, update gridsquare
                  for(int i=0;i<sections.length;i++){
                     if(currShip.isHorizontal()){
                        
                        //Update the logical gridsquares to be occupied, and retrieve icons for visual grid
                        GridSquare gs = board.getGridSquare(square.getRow() + i, square.getCol());
                        gs.setShipSection(sections[i]);
                        gs.updateIcon();
                        ImageIcon buttIcon = gs.getIcon();
                        buttIcon = resizeImage(buttIcon);
                        
                        //Update the buttons on the grid to reflect ship being placed there
                        JButton butt = getGridButton(gs.getRow(), gs.getCol());
                        butt.setIcon(buttIcon);
                        butt.repaint();
                        butt.revalidate();
                        
                        
                     }
                     else{
                        GridSquare gs = board.getGridSquare(square.getRow(), square.getCol() + i);
                        gs.setShipSection(sections[i]);
                        gs.updateIcon();
                        ImageIcon buttIcon = gs.getIcon();
                        buttIcon = resizeImage(buttIcon);
                        
                        JButton butt = getGridButton(gs.getRow(), gs.getCol());
                        butt.setIcon(buttIcon);
                        butt.repaint();
                        butt.revalidate();
                     }
                  }
                  //Redraw ShipYard
                  //Update the ship yard with next ship
                  currShipNum++;
                  currShip = ships[currShipNum];
                  shipStuff.remove(shipYard);
                  shipYard = drawShip(currShip);
                  shipStuff.add(shipYard, 0);
                  shipStuff.repaint();
                  shipStuff.revalidate();
                }
                else{
                  //
                  ;
                }
            }
        });
        return b;
    }
    
       
      public static void main(String[] args){
         MainGui main= new MainGui();
      }
}