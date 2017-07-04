import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Run {
	/* 
	 * Test run Gui.
	 */

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new TextFields();
         }
      });
   }
}

