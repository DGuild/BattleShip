import java.util.Random;

public class ComputerPlayer{
   ComputerAI ai;
   Grid g;
   Fleet f;
   
   public ComputerPlayer(ComputerAI a){
      this.ai = a;
      g = new Grid();
      f = new Fleet();
   }
   
   public Grid getComputerPlayerGrid(){
      return g;
   }
   
   public void generateComputerPlayerGrid(){
      Ship[] ships = f.returnShip();
      for(Ship ship : ships){
         boolean fits = false;
         while(!fits){
            //Select a square at Random to place ship
            Random r = new Random();
            int col = r.nextInt(10);
            int row = r.nextInt(10);
            GridSquare gs = g.getGridSquare(col,row);
            //Check that the ship can be placed (no edge, no other ship)
            fits = g.shipFits(ship, gs);
            //Place ship by updating squares to be occupied
            if(fits){
               g.placeShip(ship, gs);
            } 
         } 
         
      }
      
   }

}