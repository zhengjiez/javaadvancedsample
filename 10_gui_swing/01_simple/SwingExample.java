import javax.swing.*;

public class SwingExample {
   // Constructor.
   SwingExample() {
      // frame is a window.
      JFrame frame = new JFrame("Hello, World! Application");
      frame.setSize(350,150);

      // How do we want the frame to close.
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a label.
      JLabel label = new JLabel("Hello, world!");
      frame.add(label);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      // Run Gui program in its own thread.
      // Constructor of a Runnable object.
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new SwingExample();
         }
      });
   }
}
