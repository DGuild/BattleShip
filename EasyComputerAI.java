import java.util.*;
public class EasyComputerAI implements ComputerAI{

   private Stack nextGuesses = new Stack();
   
   public void addMove(){
      GridSquare guess = this.generateRandomGridSquare();
      nextGuesses.push(guess);
   }
   
   public GridSquare generateRandomGridSquare(Grid g){
      Random r = new Random();
      int row = r.randInt(10);
      int col = r.randInt(10);
      GridSquare square = g.getGridSquare(row,col); 
      return square;
   }
   
}