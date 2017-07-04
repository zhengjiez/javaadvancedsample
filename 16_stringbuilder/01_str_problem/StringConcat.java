import java.io.*;
import java.util.*;

// StringBuilder is much faster.
public class StringConcat {
   public static void main(String[] args) {
      BufferedReader input;

      String word, words;
      word = words = "";

      //String file = "c:\\data\\animals1.txt";
      String file = "/home/zhu/study/flex/prog/tests/java/advanced-udemy/contents/16_stringbuilder/animals1.txt";

      // Keep track of time it takes to concate strings.
      long startTime, stopTime, duration;
      startTime = stopTime = duration = 0;

      // Use String.
      try {
         input = new BufferedReader(new FileReader(file));

         startTime = System.nanoTime();
         while ((word = input.readLine()) != null) {
            words += word + ",";
         }
         stopTime = System.nanoTime();
         duration = stopTime - startTime;

      }
      catch (IOException e) {
         System.out.println(e.toString());
      }

      System.out.println("Time to concatenate: " + duration);

      // Using StringBuilder.
      startTime = stopTime = duration = 0;
      StringBuilder sbWords = new StringBuilder();

      try {
         input = new BufferedReader(new FileReader(file));
         startTime = System.nanoTime();
         while ((word = input.readLine()) != null) {
            sbWords.append(word + ",");
         }
         stopTime = System.nanoTime();
         duration = stopTime - startTime;
      }
      catch (IOException e) {
         System.out.println(e.toString());
      }

      System.out.println("Time to append: " + duration);
   }
}
