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
      this.setVisible(true);
   }
   
   public static void main(String[] args){
      new GridIconTestGUI();
   }
}  