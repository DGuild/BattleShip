import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
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
   
   /**
   * If it fits, it ships
   */
   
   public boolean shipFits(Ship s, GridSquare gs){
      ShipSection[] sections = s.getSections();
      boolean fits = true;
      for(int i=0;i<sections.length;i++){
         if(s.isHorizontal()){
            try{
               GridSquare square = this.getGridSquare(gs.getRow() + i, gs.getCol());
               if(gs.isOccupied()) fits = false;
            }
            catch(ArrayIndexOutOfBoundsException a){
               fits = false;
            }
          }
          else{
             try{
                GridSquare square = this.getGridSquare(gs.getRow(), gs.getCol() + i);
                if(gs.isOccupied()) fits = false;
             }
             catch(ArrayIndexOutOfBoundsException a){
                fits = false;
             }
          }
       }
       return fits;
   }
   
   /**
   * Place Ship on Grid starting at specific GridSquare
   * Returns the array of affected GridSquares
   */
   
   public ArrayList<GridSquare> placeShip(Ship s, GridSquare gs){
      ShipSection[] sections = s.getSections();
      int index = 0;
      ArrayList<GridSquare> squares = new ArrayList<GridSquare>(sections.length);
      GridSquare square;
      //Update the logical gridsquares to be occupied, and retrieve icons for visual grid
      for(int i=0;i<sections.length;i++){           
         if(s.isHorizontal()){   
            square = this.getGridSquare(gs.getRow() + i, gs.getCol());
         }
         else{
            square = this.getGridSquare(gs.getRow(), gs.getCol() + i); 
         }
         square.setShipSection(sections[i]);
         square.updateIcon();
         squares.add(index,square);
         index++;
      }
      return squares;
   }
}