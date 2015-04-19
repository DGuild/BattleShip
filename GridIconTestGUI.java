import javax.swing.*;
import java.awt.*;
public class GridIconTestGUI extends JFrame{

   private JPanel panel;
   private Grid g;
   
   public GridIconTestGUI(){
      Container pane = getContentPane();
      g = new Grid();
      panel = g.drawGrid();
      pane.add(panel);
      this.pack();
      this.setSize(334, 334);
      this.setVisible(true);
   }
   public void placeShip(Ship i){
      Boolean hor= i.isHorizontal;
   }
   
   public static void main(String[] args){
      new GridIconTestGUI();
   }
}  