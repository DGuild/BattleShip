public class GridSquare{

   ShipSection shipSection;
   
   public GridSquare(){
      shipSection=null;
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

}