import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Lists {
   JLabel label;
   JList list;
   String[] nycsites;
   
   public Lists() {
      label = new JLabel("");
      nycsites = new String[]{"Empire State Building", "Ground Zero",
                              "Statue of Liberty", "Wall Street",
                              "Central Park", "Times Square"};

      // Create a list.
      list = new JList(nycsites);

      // Set selection mode (single selection).
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Selection listener.
      list.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent le) {

            // The index of selected value in the list.
            int index = list.getSelectedIndex();
            if (index != -1) {
               label.setText("Site to visit: " + nycsites[index]);
            }
         }
      });

      // Define a frame.
      JFrame frame = new JFrame("Using Lists");
      frame.setLayout(new FlowLayout());
      frame.setSize(500,250);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(list);
      frame.add(label);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Lists();
         }
      });
   }
}
