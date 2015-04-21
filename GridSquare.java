import javax.swing.ImageIcon;
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
public class GridSquare{

   ShipSection shipSection;
   int col;
   int row;
   ImageIcon squareIcon;
   boolean guessed;
   
   public GridSquare(int col, int row){
      shipSection=null;
      this.col = col;
      this.row = row;
      squareIcon = new ImageIcon("square.png");
      guessed = false;
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
   public void setGuessed(){
      guessed=true;
   }
   
   public int getCol(){
      return col;
   }
   
   public int getRow(){
      return row;
   }
   
   public boolean isGuessed(){
      return guessed;
   }
   
   public ImageIcon getIcon(){
      return squareIcon;
   }
   
   public void updateIcon(){
      if(this.isOccupied()){
         if(this.getShipSection().isHit()){
            squareIcon = new ImageIcon("shipSplode.png");
            
         }
         else{
            squareIcon = new ImageIcon("shipSection.png");
         }
      }
      else{
         squareIcon = new ImageIcon("square.png");
         if(this.isGuessed()){
            squareIcon = new ImageIcon("miss.png");
         }
      }
   }
   /*
   public static synchronized void playSound(final String url) {
  new Thread(new Runnable() {
  // The wrapper thread is unnecessary, unless it blocks on the
  // Clip finishing; see comments.
    public void run() {
      try {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
          Main.class.getResourceAsStream("/path/to/sounds/" + url));
        clip.open(inputStream);
        clip.start(); 
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
    }
  }).start();
}*/

}