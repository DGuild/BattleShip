import javax.swing.*;
public class Ship{

   private ShipSection[] sections;
   private String name;
   
   /**
   * Creates a ship with n sections
   */
   public Ship(int n){
      sections = new ShipSection[n];
      this.name = nameShip(n);
      for(int i=0;i<sections.length;i++){
         ShipSection ships= new ShipSection();
         sections[i]= new ShipSection();
      }
   }
   
   /**
   * Returns true if all ship sections have been hit. Otherwise, returns false
   */
   public boolean isSunk(){
      for(ShipSection section : sections){
         if (!section.isHit()){
            return false;
         }
      }
      return true;
   }
   
   
   /**
   * Returns an array of icons for the ship
   */
   public ImageIcon[] getImage(){
      ImageIcon[] icons = new ImageIcon[sections.length];
      for(int i = 0; i < sections.length; i++){
         icons[i] = sections[i].getImage();
      }
      return icons;
   }
   
   /**
   * Returns the proper name for the ship given a length i.e if given 4 returns Battleship
   */
   private String nameShip(int n){
      String[] names = {"Destroyer", "Cruiser", "Battleship", "Aircraft Carrier"};
      
      String name = names[n-2];
      return name;
   }
   
   
   
   
}