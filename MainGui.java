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
   ComputerPlayer computer;
   int shipnum= -1;
   int rotationNum=0;
   private static final int WIDTH = 1000;
   private static final int HEIGHT = 1000;
   private static final int N = 10;
   private final ArrayList<JButton> pList = new ArrayList<JButton>();
   private final ArrayList<JButton> cList = new ArrayList<JButton>();
    
   private JLabel title, pshipYard;
   private JPanel playerGrid, compGrid;
   private JTextField output;
   private Grid board = new Grid();
   
   private Grid cBoard = new Grid();
   private boolean setupMode = true;
   //Player player= new Player();
      // private BufferedImage myPicture;
   Fleet fleet= new Fleet();
   JPanel shipStuff;
   Ship[] ships;
   int currShipNum;
   Ship currShip;
   JPanel shipYard;
    


    
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
       // computer.generateComputerPlayerGrid();
       // cBoard=computer.getComputerPlayerGrid();
        compGrid = drawGrid(cBoard, compGrid, cList);
        playerGrid = drawGrid(board,playerGrid, pList);
        
        
        
        //set up shipyard
        shipStuff = new JPanel();
        ships = fleet.returnShip();
        currShipNum = 0;
        currShip = ships[currShipNum];
        shipYard= drawShip(currShip);
        //The shipyard buttons
        JPanel buttons= new JPanel();
        JButton flip= new JButton("Flip");
        buttons.add(flip);
        
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
        pane.add(playerGrid);
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
         Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
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
      
      public JPanel drawGrid(Grid g, JPanel pp, ArrayList<JButton> list){
         pp = new JPanel();
         pp.setLayout(new GridLayout(10,10));
         for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
               JButton l=createGridButton(i,j, g, list);
               //ImageIcon icon = grid[i][j].getIcon(); //Get the icon from the gridsquare
               //icon = resizeImage(icon);
               //JButton l = new JButton(icon); //Put the icon on a label
               list.add(l);
               pp.add(l);
            }
         }
         return pp;
      }
      private JButton getGridButton(int r, int c, ArrayList<JButton> list) {
        int index = r * N + c;
        return list.get(index);
      }

      private JButton createGridButton(final int row, final int col, Grid g, ArrayList<JButton> list) {
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
                  //If ship fits on board, update gridsquare
                  if(board.shipFits(currShip, square)){
                  
                     
                     ArrayList<GridSquare> updatedSquares = board.placeShip(currShip, square);
                     for (GridSquare updatedSquare : updatedSquares){
                        ImageIcon buttIcon = updatedSquare.getIcon();
                        buttIcon = resizeImage(buttIcon);
                        JButton butt = getGridButton(updatedSquare.getRow(), updatedSquare.getCol(), pList);
                        butt.setIcon(buttIcon);
                        butt.repaint();
                        butt.revalidate();
                     }
                     
                     
                  
                  //Redraw ShipYard
                  //Update the ship yard with next ship
                     try{
                        currShipNum++;
                        currShip = ships[currShipNum];
                        shipStuff.remove(shipYard);
                        shipYard = drawShip(currShip);
                        shipStuff.add(shipYard, 0);
                        shipStuff.repaint();
                        shipStuff.revalidate();
                     }
                     catch(IndexOutOfBoundsException i){
                        shipStuff.remove(shipYard);
                        shipStuff.repaint();
                        shipStuff.revalidate();
                        mainGame();
                     }
                  }
                  else{
                     JOptionPane popUp = new JOptionPane();
                     popUp.showMessageDialog(null, "Cannot Place Ship There.");
                  }
                }
                
                //If in GAME Mode, this is what the button clicks do
                else{
                  //
                  GridSquare gs = cBoard.getGridSquare(square.getRow(), square.getCol());
                  
                  if(!(gs.isGuessed())){
                     if(gs.isOccupied()){
                        gs.getShipSection().getHit();
                     }
                     gs.setGuessed();
                     gs.updateIcon();
                     ImageIcon newIcon = gs.getIcon();
                     newIcon = resizeImage(newIcon);
                     JButton icon = getGridButton(gs.getRow(), gs.getCol(), cList);
                     icon.setIcon(newIcon);
                     icon.setIcon(newIcon);
                     icon.repaint();
                     icon.revalidate();
                  }else{
                     //tell user is guessed already
                  }
                }
            }
        });
        return b;
    }
    
    public void mainGame(){
      this.remove(title);
      this.add(compGrid, 1);
      computer= new ComputerPlayer(new EasyComputerAI(board));
      setupMode = false;
    }
    
       
      public static void main(String[] args){
         MainGui main= new MainGui();
      }
}