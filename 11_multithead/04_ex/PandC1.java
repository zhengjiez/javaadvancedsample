class Market {
   // The Market object is the shared object to be synchronized.
   int n;
   boolean valSet = false;
   synchronized int get() {
      // you need to ensure that any calls        
      // to wait() or notify() are within a       
      // synchronized region of code (with        
      // the wait() and notify() calls being      
      // synchronized on the same object).        
      if (!valSet) {
         try {
            wait();
         }
         catch (InterruptedException e) {
            System.out.println("Interrupted");
         }
      }
      System.out.println("Got: " + n);
      valSet = false;
      notify();
      return n;
   }

   synchronized void put(int n) {
      if (valSet) {
         try {
            wait();
         }
         catch (InterruptedException e) {
            System.out.println("Interrupted.");
         }
      }
      this.n = n;
      valSet = true;
      System.out.println("Put: " + n);
      notify();
   }
}

class Producer implements Runnable {
   Market m;
   
   public Producer(Market m) {
      this.m = m;
      new Thread(this, "Producer").start();
   }

   public void run() {
      int i = 0;
      while (true) {
         m.put(i++);
      }
   }
}

class Consumer implements Runnable {
   Market m;

   public Consumer(Market m) {
      this.m = m;
      new Thread(this,"Consumer").start();
   }

   public void run() {
      while (true) {
         m.get();
      }
   }
}

class PandC1 {
   public static void main(String[] args) {
      Market m = new Market();
      new Producer(m);
      new Consumer(m);
      System.out.println("Stop by pressing Ctrl-C");
   }
}
      
