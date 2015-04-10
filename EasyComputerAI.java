import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
public class EasyComputerAI implements ComputerAI{

   private Stack nextGuesses = new Stack();
   private ArrayList<GridSquare> alreadyGuessedSquares = new ArrayList<GridSquare>();
   private Grid grid;
   
   public EasyComputerAI(Grid g){
      this.grid = g;
   }
   
   public void addMove(){
      //NOTE: This might be a very inefficient algorithm for getting squares,
      // since as the number of UNguessed squares gets less, it will take longer
      // to randomly select them
      
      GridSquare guess = this.generateRandomGridSquare(grid);
      while(alreadyGuessedSquares.contains(guess)){ //Get new square, if one is already guessed
         guess = this.generateRandomGridSquare(grid);
      }
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
      alreadyGuessedSquares.add(guess);
      return guess;
   }
   
}