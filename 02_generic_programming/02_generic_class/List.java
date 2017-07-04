public class List<T> {
   
   private T[] datastore;
   private int size;
   private int pos;

   public List(int numElements) {
      size = numElements;
      pos = 0;

      // Create an Object array and cast it into the data type
      // that is going to be provide when we instantiate the List.
      datastore = (T[]) new Object[size];
   }

   public void add (T element) {
       datastore[pos] = element;
       ++pos;
   }

   public String toString () {
       String elements = "";
       for (int i=0; i<pos; i++) {
           elements += datastore[i] + " ";
       }
       return elements;
   }
}
