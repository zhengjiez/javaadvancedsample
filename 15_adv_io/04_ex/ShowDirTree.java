import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
// Display contents of a directory tree.

// FileVisitor class is run each time when visiting a certain path.
class FileVisitor extends SimpleFileVisitor<Path> {
   public FileVisitResult visitFile(Path path, BasicFileAttributes 
                                    attributes) throws IOException {
      System.out.println(path);

      // Continue to read more files and directories.
      return FileVisitResult.CONTINUE;
   }
}

public class ShowDirTree {
   public static void main(String[] args) {
      String dir = args[0];

      System.out.println("Starting directory: " + dir + ": ");

      try {
         Files.walkFileTree(Paths.get(dir), new FileVisitor());
      }
      catch (IOException e) {
         System.out.println("Error walking directory tree.");
      }
   }
}
