import javax.swing.ImageIcon;
public class Ship{

   private ShipSection[] sections;
   private String name;
   private boolean horizontal;
   private int length;
   
   /**
   * Creates a ship with n sections
   */
   public Ship(int n){
      sections = new ShipSection[n];
      //Initialize array of sections to point to ShipSection objects
      for(int i = 0; i < n; i++){
         sections[i] = new ShipSection();
      }
      this.name = nameShip(n);
      this.length = n;
      this.horizontal = true;
   }
   
   /**
   * Return the array of Ship Sections
   */
   public ShipSection[] getSections(){
      return sections;
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
   
   /**
   * Returns the horizontal orientation
   */
   public boolean isHorizontal(){
      return horizontal;
   }
   
   public int getLength(){
      return length;
   }
   
   /**
   * Toggles ship orientation
   */
   public void rotate(){
      this.horizontal = !horizontal;
   }
   
   
}