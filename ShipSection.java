import javax.swing.*;
public class ShipSection{
   ImageIcon icon= new ImageIcon("shipSection.png");
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
   public ImageIcon getImage(){
      return icon;
   }
}