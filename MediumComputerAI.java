public class MediumComputerAI implements ComputerAI{

   private Stack nextGuesses = new Stack();
   private GridSquare lastGuess;
   private boolean targetMode = false;
   private Grid grid;
   
   public void addMove(){
      if(targetMode){
         GridSquare[] guesses = this.generateRandomGridSquare(this.grid, GridSquare lastGuess)
         for(GridSquare guess : guesses){
            nextGuesses.push(guess);
         }
      }
      else{
         GridSquare guess = this.generateRandomGridSquare(this.grid);
         nextGuesses.push(guess);
      }
      
   }
   
   public GridSquare getNextMove(){
      nextGuesses.pop();
   }
   
   public void toggleTargetMode(){
      if(this.lastGuess.hasShipSection()) targetMode = true;
      else targetMode = false;
   }
   
   private GridSquare generateRandomGridSquare(Grid g){
      Random r = new Random();
      int col = r.randInt(10);
      int row = r.randInt(10);
      GridSquare square = g.getGridSquare(col row); 
      return square;
   }
   
   /**
   * Generates an array of Grid Squares that surround a given Grid Square
   */
   private GridSquare[] generateTargetedGridSquare(Grid g, GridSquare s)
      GridSquare[] squares = new GridSquare[4];
      int targetCol = s.getRow();
      int targetRow = s.getCol();
      squares[0] = g.getGridSquare(targetCol, targetRow -1); //square to the top
      squares[1] = g.getGridSquare(targetCol + 1, targetRow); //square to the right
      squares[2] = g.getGridSquare(targetCol, targetRow + 1); //square to the bottom
      squares[3] = g.getGridSquare(targetCol - 1, targetRow); //square to the left
      return squares;

}