import java.io.*;
import java.nio.*;
import java.nio.channels.*;

// Rather than working with file and stream, the NIO works with
// file and channels.
public class FileCopy {
   public static void main(String[] args) throws IOException {
      File sourceFile = new File(args[0]);
      File destFile = new File(args[1]);
      if (!destFile.exists()) {
         destFile.createNewFile();
      }

      FileChannel sourceChannel = null;
      FileChannel destChannel = null;

      try {
         // Associate source and destination files with channel.
         sourceChannel = new FileInputStream(sourceFile).getChannel();
         destChannel = new FileOutputStream(destFile).getChannel();

         // Execute file copying.
         // from 0 bytes all the way to the full length of the data
         // in the source channel.
         //
         // This way of copying is very quick compared to setting up
         // a loop and copy byte by byte.
         destChannel.transferFrom(sourceChannel,0,sourceChannel.size());
      }
      finally {
         if (sourceChannel != null) {
             sourceChannel.close();
         }
         if (destChannel != null) {
             destChannel.close();
         }
      }
   }
}
