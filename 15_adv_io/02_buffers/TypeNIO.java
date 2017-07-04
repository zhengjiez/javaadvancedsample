import java.io.*;
import java.nio.*;
import java.nio.channels.*;

// How to use NIO to read from a buffer. We create a utility to 
// recreate the type in Dos and display the content of file on
// the screen.
public class TypeNIO {
   public static void main(String[] args) throws IOException {
      int count; // size of the buffer
      File sourceFile = new File(args[0]);
      FileChannel sourceChannel = new FileInputStream(sourceFile).
                                     getChannel();

      // Work with buffer.
      try {
         ByteBuffer buffer = ByteBuffer.allocate(1024);
         do {
            count = sourceChannel.read(buffer);

            // if the buffer is not empty.
            if (count != -1) {
               buffer.rewind(); // get back to the buffer begining.
               for (int i = 0; i < count; ++i) {
                  System.out.print((char)buffer.get());
               }
            }
         } while (count != -1);
      }
      catch (IOException e) {
         System.out.println("Error reading file.");
      }
   }
}
