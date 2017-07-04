import java.io.*;
import java.nio.file.*;

// This code needs JAVA 7 to run.
// Returning info of a file.
public class FileData {
   public static void main(String[] args) {
      Path filePath = Paths.get(args[0]);

      // Get only the name of the file.
      System.out.println("File name: " 
          + filePath.getName(filePath.getNameCount() - 1));
      System.out.println(filePath.getNameCount());

      // Get info of the file.
      try {
         // If hidden.
         if (!Files.isHidden(filePath))  {
            System.out.println("File is not hidden.");
         }
         else {
            System.out.println("File is hidden.");
         }

         // If writable.
         if (Files.isWritable(filePath)) {
            System.out.println("File is writable.");
         }

         // If readable.
         if (Files.isReadable(filePath)) {
            System.out.println("File is readable.");
         }
      }
      catch (IOException e) {
         System.out.println("Error checking file attributes.");
      }
   }
}
