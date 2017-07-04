import java.util.regex.*;

public class RegEx1 {
   public static void main(String[] args) {
      String words    = "now is the time or now is not the time";
      String patt     = "now";
      Pattern pattern = Pattern.compile(patt);
      Matcher match   = pattern.matcher(words);

      System.out.println(words);

      while (match.find()) {
         System.out.println("Found " + patt + " at: " + match.start());

         // group() returns the sequence of the characters that
         // regExp matched.
         System.out.println("Match: " + match.group());
      } 
   }
}
