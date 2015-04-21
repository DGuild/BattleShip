public class Fleet{
   Ship[] ships;
   int count=-1;
   int[] shipSizes= {2,3,3,4,5};
   public Fleet(){
      ships = new Ship[5];
      int shipNum = 0; //which ship we are constructing
      for (int size : shipSizes){
         ships[shipNum] = new Ship(shipSizes[shipNum]);//Initialize the ship with appropriate length
         shipNum++; //get ready to construct next ship
      }
   }
   
   public boolean allShipsSunk(){
      boolean sunk = true;
      for(Ship s: ships){
         ShipSection[] sections = s.getSections();
         for (ShipSection section : sections){
            if(!section.isHit()){
               sunk = false;
            }
         }
      }
      return sunk;
   }
   
   public Ship[] returnShip(){
      return ships;
   }

   
}