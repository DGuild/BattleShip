import java.util.*;
public interface ComputerAI{

   Stack nextGuesses = new Stack();
   
   public void addMove();
   
   public GridSquare generateRandomGridSquare();
}