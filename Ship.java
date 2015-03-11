public class Ship{

   private ShipSection[] sections;
   
   /**
   * Creates a ship with n sections
   */
   public Ship(int n){
      sections = new ShipSection[n];
   }
   
   /**
   * Returns true if all ship sections have been hit. Otherwise, returns false
   */
   public boolean isSunk(){
      for(section : sections){
         if (!section.isHit){
            return false
         }
      }
      return true;
   }
   
   
}