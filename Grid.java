import javax.swing.*;
import java.awt.*;
import javax.imageio.*;

public class Grid{
   GridSquare grid[][]= new GridSquare[10][10];
   public Grid(){
      for (int i=0;i<10;i++){
         for (int j=0;j<10;j++){
             grid[i][j]= new GridSquare(i,j);
         }
      }
   }
   
   public GridSquare getGridSquare(int col, int row){
      GridSquare square = grid[col][row];
      return square;
   }
   
   public JPanel drawGrid(){
      JPanel jp = new JPanel();
      jp.setLayout(new GridLayout(10,10));
      for (int i=0;i<10;i++){
         for (int j=0;j<10;j++){
             ImageIcon icon = grid[i][j].getIcon(); //Get the icon from the gridsquare
             icon = resizeImage(icon);
             JButton l = new JButton(icon); //Put the icon on a label
             jp.add(l);
         }
      }
      return jp;
   }
   
   public ImageIcon resizeImage(ImageIcon i){
      /*
         Image img = i.getImage();
         //Now create a buffered image the same size as the image:
         BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
         //Then blit the icon image to the buffered image, and resize it as you do so:
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
}