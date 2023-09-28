import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    // prompt
    System.out.print("Enter number for radius: ");
    double radius = input.nextDouble();

    input.close();

    // area
    double area = radius * radius * 3.14159;

    // if
    if (radius < 0) {
      System.out.println("wrong");
    }

    // results
    else {
      System.out.println("The area for the circle of radius " +
      radius + " is " + area);
    }
  }
}
