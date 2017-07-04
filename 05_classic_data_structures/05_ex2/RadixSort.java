import java.util.LinkedList;

public class RadixSort {

   static void Distribute(int[] arr, LinkedList[] digits, 
                          String digitType) {
      for (int i = 0; i < arr.length; i++) {
         if (digitType.equals("ones")) {
            digits[arr[i] % 10].addLast(arr[i]);
         }
         else {
            digits[arr[i] / 10].addLast(arr[i]);
         }
      }
   }

   static void Collect(LinkedList[] digits, int[] arr) {
      int i = 0;
      for (int digit = 0; digit < 10; ++digit) {
         while (!digits[digit].isEmpty()) {
            arr[i++] = (Integer)digits[digit].removeFirst();
         }
      }
   }

   static void display(int[] arr) {
      // Display numbers in lines of 10.
      //
      // Print an array of integers in multiple lines
      // Each line contains 10 numbers.
      int i = 0;
      while (i < arr.length) {
          System.out.print(arr[i] + " ");
          if (++i % 10 == 0)
             System.out.println();
      }
      System.out.println();
   }

   public static void main(String[] args) {
      final int size = 50;
      final int numQueues = 10;
      LinkedList<Integer>[] digits = new LinkedList[numQueues];
      
      // digits is a list of lists.
      //
      // If "ones" is selected, then:
      //
      // The first  element is a list containing integers ends with 1.
      // The second element is a list containing integers ends with 2.
      // The third  element is a list containing integers ends with 3.
      // ...
      // ...
      // The tenth  element is a list containing integers ends with 0.
      //
      // If "tens" is selected, then:
      //
      // The first  element is a list containing integers 1-10.
      // The second element is a list containing integers 11-20.
      // The third  element is a list containing integers 21-30.
      // ...
      // ...
      // The tenth  element is a list containing integers 91-100.
      for (int i = 0; i < numQueues; ++i) {
         digits[i] = new LinkedList();
      }

      // Create an array of integers holding 50 random integers [1-100].
      int[] numbers = new int[size];
      for (int i = 0; i < size; ++i) {
         numbers[i] = (int)(Math.random() * 100);
      }

      display(numbers);

      Distribute(numbers, digits, "ones");
      Collect(digits, numbers);
      display(numbers);

      Distribute(numbers, digits, "tens");
      Collect(digits, numbers);
      display(numbers);
   }
}
