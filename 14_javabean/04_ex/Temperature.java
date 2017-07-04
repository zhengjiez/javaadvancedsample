import java.io.Serializable;

// We need to be able to save the state of the class.
public class Temperature implements Serializable {
   private double temp;
   public Temperature() {
      temp =  0.0;
   }

   public double getTemp() {
      return temp;
   }

   public void setTemp(double t) {
      temp = t;
   }

   public void cToF() {
      temp = temp * (9.0/5.0) + 32.0;
   }

   public void fToC() {
      temp = (temp - 32.0) * (5.0/9.0);
   }
}
