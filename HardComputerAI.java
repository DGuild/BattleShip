import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class HardComputerAI implements ComputerAI{

   Stack nextGuesses = new Stack();
   private ArrayList<GridSquare> alreadyGuessedSquares = new ArrayList<GridSquare>();
   private Grid grid;
   
   public void addMove(){
      GridSquare guess = generateRandomGridSquare(grid);
      nextGuesses.push(guess);
   }
   
   //Method is misnamed - these GridSquares are being intentionally sought out
   public GridSquare generateRandomGridSquare(Grid g){
      for(int i = 0; i < 10; i++){
         for(int j = 0; j < 10; j++){
            GridSquare square = g.getGridSquare(i,j);
            if(square.isOccupied() && !alreadyGuessedSquares.contains(square)){
               return square;
            }
         }
      }
      return g.getGridSquare(0,0);
   }

}