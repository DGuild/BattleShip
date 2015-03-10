public class Grid{
   GridSquare grid[][]= new GridSquare[10][10];
   public Grid(){
      for (int i=0;i<10;i++){
         for (int j=0;j<10;j++){
             grid[i][j]= new GridSquare();
         }
      }
   }
}