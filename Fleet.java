public class Fleet{
   Ship[] ships;
   int count=-1;
   int[] shipSizes= {2,3,3,4,5};
   public Fleet(){
      ships = new Ship[5];
      for (int size : shipSizes){
         int shipNum = 0;
         ships[shipNum] = new Ship(shipSizes[shipNum]);
         shipNum++;
      }
   }
   public int rotateShip(){
      count++;
      return shipSizes[count];
   }


}