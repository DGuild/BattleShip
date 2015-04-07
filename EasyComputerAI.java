import java.util.Random;
import java.util.Stack;
public class EasyComputerAI implements ComputerAI{

   private Stack nextGuesses = new Stack();
   private Grid grid;
   
   public EasyComputerAI(Grid g){
      this.grid = g;
   }
   
   public void addMove(){
      GridSquare guess = this.generateRandomGridSquare(grid);
      nextGuesses.push(guess);
   }
   
   public GridSquare generateRandomGridSquare(Grid g){
      Random r = new Random();
      int row = r.nextInt(10);
      int col = r.nextInt(10);
      GridSquare square = g.getGridSquare(row,col); 
      return square;
   }
   
   public GridSquare getNextMove(){
      GridSquare guess = (GridSquare) nextGuesses.pop();
      return guess;
   }
   
}