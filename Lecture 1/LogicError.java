public class LogicError {
    public static void main(String[] args) {
        System.out.print("Celcius 35 is Farenheit degree ");
        // The following code will execute 1 $\times$ 35 + 32 instead of 1.8 $\times$ 35 + 32
        System.out.println((9/5)*35+32);

        System.out.println((9.0/5.0)*35+32);
   }
}
