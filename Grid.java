import javax.swing.*;
import java.awt.GridLayout;

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
      JPanel jp = new JPanel(new GridLayout(10,10));
      JLabel[][] icons = new JLabel[10][10];
      for (int i=0;i<10;i++){
         for (int j=0;j<10;j++){
             ImageIcon icon = grid[i][j].getIcon(); //Get the icon from the gridsquare
             icons[i][j] = new JLabel(icon); //Put the icon on a label
             
         }
      }
      jp.add(icons);
      return jp;
   }
}