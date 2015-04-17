import javax.swing.*;
import java.awt.*;
public class DumbTestGUI extends JFrame{

   private JPanel panel;
   private Grid g;
   
   public DumbTestGUI(){
      g = new Grid();
      panel = new JPanel(new GridLayout(10,10));
      JLabel[] icons = new JLabel[];
      JLabel l = new JLabel(new ImageIcon("square.png"));
      JLabel l2 = new JLabel(new ImageIcon("square.png"));
      panel.add(l);
      panel.add(l2);
      this.add(panel);
      this.pack();
      this.setVisible(true);
   }
   
   public static void main(String[] args){
      new DumbTestGUI();
   }
}  