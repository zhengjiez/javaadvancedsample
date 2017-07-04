import java.util.TreeSet;

// If you only sort once, then the ArrayList is an
// obvious winner. The TreeSet is better if you add
// or remove items often as sorting a list again and
// again would be slow.


public class Alpha {
   public static void main(String[] args) {

      TreeSet<String> names = new TreeSet<String>();
      names.add("Raymond");
      names.add("Mike");
      names.add("Bryan");
      names.add("Jennifer");
      names.add("Clayton");
      names.add("Terrill");
      names.add("Terrill"); // Duplicated terms will be removed

      System.out.println("Number of names = " + names.size());

      for (String name : names) {
         System.out.println(name);
      }

      System.out.println("Name before Jennifer: " + names.lower("Jennifer"));
      System.out.println("Name after Jennifer: " + names.higher("Jennifer"));
      System.out.println("First element: " + names.first());
      System.out.println("Last element: " + names.last());
   }
}
