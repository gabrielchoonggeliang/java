import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        // variable declaration
        double radius;
        final double PI = 3.14159;
        double area;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a radius: ");
        radius = input.nextDouble();
        input.close();

        // formula of area of circle
        area = radius * radius * PI;

        System.out.printf("The area for the circle of radius %.2f is %.2f\n", radius, area);
        // or
        // System.out.print("The area for the circle of radius " + radius + "is " + format("%.2f", area));
    }
}