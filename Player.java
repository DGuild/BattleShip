public class Player{
   
   private Fleet fleet;
   private Grid grid;
   
   public Player(){
      this.fleet = new Fleet();
      this.grid = new Grid();
   }
   
   public boolean takeShot(GridSquare g){
      if(g.isOccupied){
         ShipSection shipSection = g.getShipSection();
         shipSection.getHit();
         g.gotGuessed();
         return true;
      }
      else{
         got.guessed();
         return false;
      }
   }
}