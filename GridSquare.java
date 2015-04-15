import javax.swing.ImageIcon;
public class GridSquare{

   ShipSection shipSection;
   int col;
   int row;
   ImageIcon squareIcon;
   
   public GridSquare(int col, int row){
      shipSection=null;
      this.col = col;
      this.row = row;
      squareIcon = "square.png"
   }
   
   public ShipSection getShipSection(){
      return shipSection;
   }
   
   public void setShipSection(ShipSection s){
    this.shipSection = s;
   }
   
   public boolean isOccupied(){
      return (shipSection != null);
   }
   
   public int getCol(){
      return col;
   }
   
   public int getRow(){
      return row;
   }
   
   public getIcon(){
      return squareIcon;
   }

}