import java.beans.*;

public class TempInfo extends SimpleBeanInfo {
   public PropertyDescriptor[] getPropertyDescriptors() {
      try {
         PropertyDescriptor temp = 
            // temp: name of the property
            //
            // Temperature.class: class where the property is defined
            // which is our compiled Temperature class.
            new PropertyDescriptor("temp", Temperature.class);

         // We create an array of PropertyDescriptor type, pd
         // and retrieve the data stored in our PropertyDescriptor
         // object.
         PropertyDescriptor pd[] = {temp};
         return pd;
      }
      catch (Exception e) {
         System.out.println("Exception thrown retrieving properties.");
      }
      // return null upon exception.
      // The method has to return something.
      return null;
   }
}
