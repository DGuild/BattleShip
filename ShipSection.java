public class ShipSection{

   private boolean hit;
   
   public ShipSection(){
      this.hit = false;
   }
   
   public void getHit(){
      this.hit = true;
   }
   
   public boolean isHit(){
      return hit;
   }

}