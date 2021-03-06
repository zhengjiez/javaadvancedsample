import java.beans.*;

// Using this TempInspection program, we can write another program
// to look at our Temperature class, and figure out what properties
// and methods are, which help us to figure out how to interact with
// that class.
public class TempInspection {
   public static void main(String[] args) {
      try {
         Class cl = Class.forName("Temperature");
         BeanInfo beanInfo = Introspector.getBeanInfo(cl);

         // Display the properties.
         System.out.println("Properties of Temperature class: ");
         PropertyDescriptor propertyDescriptor[] = 
            beanInfo.getPropertyDescriptors();

         for (int i = 0; i < propertyDescriptor.length; i++) {
            System.out.println(propertyDescriptor[i].getName());
         }

         // Print a blank line.
         System.out.println();

         // Display the methods.
         System.out.println("Methods of Temperature class: ");
         MethodDescriptor methodDescriptor[] = 
            beanInfo.getMethodDescriptors();

         for (int i = 0; i < methodDescriptor.length; i++) {
            System.out.println(methodDescriptor[i].getName());
         }
      }
      catch (Exception e) {
         System.out.println("Exception thrown.");
      }
   }
}
