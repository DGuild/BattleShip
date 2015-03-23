public class Fleet{

   Ship[] ships;
   
   public Fleet(){
      ships = new Ship[5];
      int[] shipSizes = {2,3,3,4,5}
      for (int size : shipSizes){
         int shipNum = 0;
         ships[shipNum] = new Ship(shipSizes);
         shipNum++;
      }
   }


}