// this program is based on a similar program in
// Java Programming: Advanced Topics, Wigglesworth and McMillan

import java.io.*;

public class RunnableTThreads {
   public static void main(String[] args) throws InterruptedException {
      Thread firstThread = new Thread(new UserInteraction());
      firstThread.start();

      ComputeLog numProc = new ComputeLog();
      Thread secondThread = new Thread(numProc);
      secondThread.start();

      firstThread.join();
      numProc.end();
   }
}

// Runnable interface provide implementation of multi-thread
// and classes can also be inherited from base classes.
class UserInteraction implements Runnable {
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
         
class ComputeLog implements Runnable {
   private static boolean stop = false;
   public void run() {
      try {
         int i = 1;
         double d = 0;
         while (!stop) {
            d = Math.log(i++);
            // sleep(1);
            Thread.currentThread().sleep(1);
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

  
