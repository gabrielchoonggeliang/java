import java.util.Scanner;
public class FahrenheitToCelsius {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a degree in Fahrenheit: ");
    double fahrenheit = input.nextDouble();
    input.close();

    // Convert Fahrenheit to Celsius
    double celsius = ((double)5/9) * (fahrenheit - 32);
    System.out.println("Fahrenheit " + fahrenheit + " is " +
    celsius + " in Celsius");
  }
}
