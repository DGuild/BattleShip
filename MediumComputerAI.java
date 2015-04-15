import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;
public class MediumComputerAI implements ComputerAI{

   private Stack nextGuesses = new Stack();
   private ArrayList<GridSquare> alreadyGuessedSquares = new ArrayList<GridSquare>();
   private GridSquare lastGuess;
   private boolean targetMode = false;
   private Grid grid;
   
   public void addMove(){
      if(targetMode){
         GridSquare[] guesses = this.generateTargetedGridSquare(this.grid, lastGuess);
         for(GridSquare guess : guesses){
            if(!alreadyGuessedSquares.contains(guess)){
               nextGuesses.push(guess);
            }
         }
      }
      else{
         GridSquare guess = this.generateRandomGridSquare(this.grid);
         while(alreadyGuessedSquares.contains(guess)){ //Get new squaure, if one is already guessed
            guess = this.generateRandomGridSquare(grid);
         }
         nextGuesses.push(guess);
      }
      
   }
   
   public GridSquare getNextMove(){
      GridSquare guess = (GridSquare) nextGuesses.pop();
      alreadyGuessedSquares.add(guess);
      return guess;
      
   }
   
   public void toggleTargetMode(){
      if(this.lastGuess.isOccupied()) targetMode = true;
      else targetMode = false;
   }
   
   public GridSquare generateRandomGridSquare(Grid g){
      Random r = new Random();
      int col = r.nextInt(10);
      int row = r.nextInt(10);
      GridSquare square = g.getGridSquare(col, row); 
      return square;
   }
   
   /**
   * Generates an array of Grid Squares that surround a given Grid Square
   */
   private GridSquare[] generateTargetedGridSquare(Grid g, GridSquare s){
      GridSquare[] squares = new GridSquare[4];
      int targetCol = s.getRow();
      int targetRow = s.getCol();
      try{
         squares[0] = g.getGridSquare(targetCol, targetRow -1); //square to the top
      }
      catch (NullPointerException n){
         break;
      }
      try{
         squares[1] = g.getGridSquare(targetCol + 1, targetRow); //square to the right
      }
      catch (NullPointerException n){
         break;
      }
      try{
         squares[2] = g.getGridSquare(targetCol, targetRow + 1); //square to the bottom
      }
      catch (NullPointerException n){
         break;
      }
      try{
         squares[3] = g.getGridSquare(targetCol - 1, targetRow); //square to the left
      }
      catch (NullPointerException n){
         break;
      }
      return squares;
   }

}