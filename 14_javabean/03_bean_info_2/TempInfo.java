import java.beans.*;
import java.lang.reflect.Method;

// Add a method descriptor to our TempInfo program so that we can
// get a description of a method out of our java bean class.
public class TempInfo extends SimpleBeanInfo {
   public PropertyDescriptor[] getPropertyDescriptors() {
      try {
         PropertyDescriptor temp = new 
             PropertyDescriptor("temp", Temperature.class);
         PropertyDescriptor pd[] = {temp};
         return pd;
      }
      catch (Exception e) {
         System.out.println("Exception thrown.");
      }
      return null;
   }  

   public MethodDescriptor[] getMethodDescriptors() {
      try {
         Class cl = Temperature.class;

         // hold the parameters for the method.
         // In this example, methods cToF() and fToC() has no
         // parameters, hence the array of args[] is empty object.
         Class args[] = { };

         // Method descriptor of cToF().
         Method cToF = cl.getMethod("cToF", args);
         MethodDescriptor cToFDesc = new MethodDescriptor(cToF);
         cToFDesc.setShortDescription("Convert Celsius to Fahrenheit");

         // Method descriptor of fToc().
         Method fToC = cl.getMethod("fToc", args);
         MethodDescriptor fToCDesc = new MethodDescriptor(fToC);
         fToCDesc.setShortDescription("Convert Fahrenheit to Celsius");

         // Add 2 method descriptors into array.
         MethodDescriptor[] md = {cToFDesc, fToCDesc};
         return md;
      }
      catch (Exception e) {
         System.out.println("Exception thrown.");
      }
      return null;
   }
   
}
