// this program is based on a similar program in
// Java Programming: Advanced Topics, Wigglesworth and McMillan

import java.io.*;

public class TwoThreads {
   public static void main(String[] args) throws InterruptedException {
       // Assign thread to class.
      Thread firstThread = new UserInteraction();
      firstThread.start();

      // The 2nd thread is running in the background.
      Thread secondThread = new ComputeLog();
      secondThread.start();

      // join method waits for the thread process to terminate.
      //
      // join() is a instance method of java.lang.Thread
      // class which we can use join() method to ensure all
      // threads that started from main must end in order
      // in which they started and also main should end in
      // last. In other words waits for this thread to die.
      firstThread.join();

      // Once that thread is terminated, we call the end() method
      // of the second thread to stop the 2nd thread.
      //
      // Cast the thread back to the ComputeLog because end() method
      // is part of the ComputeLog, not part of the Thread class.
      ((ComputeLog) secondThread).end();
   }
}

class UserInteraction extends Thread {
   public void run() {
      try {
         BufferedReader userIn = new BufferedReader(
            new InputStreamReader(System.in));

         System.out.print("Hello, how are you? ");
         String in = userIn.readLine();

         System.out.print("What are you doing today? ");
         in = userIn.readLine();

         System.out.println(in + " sounds like fun.");
      }
      catch (IOException e) {
         System.out.println("Caught I/O exception.");
      }
   }
}
         
class ComputeLog extends Thread {
   private static boolean stop = false;

   // Thread is an interface, and the run() method is defined
   // in that interface, while its implementation is defined here.
   public void run() {
      try {
         int i = 1;
         double d = 0;
         while (!stop) {
            d = Math.log(i++);
            sleep(1);
         }
         System.out.println("The log of " + i + " is " + d);
      } 
      catch (InterruptedException e) {
         System.out.println("Thread execution was interrupted.");
      }
   }

   public void end() {
      stop = true;
   }
} 
