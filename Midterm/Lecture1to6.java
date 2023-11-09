package Midterm;
import java.util.Scanner;

public class Lecture1to6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println();

        System.out.println("How much banana?");
        System.out.print("\t>>> ");
        int n1 = input.nextInt();
        System.out.print("There are " + n1 + " banana!");

        System.out.println("The remainder of 17 / 3 = " + (17 % 3));
        System.out.println("(2.5) ^ (-2) = " + Math.pow(2.5, -2));
        System.out.println("1 / 2 = " + (1 / 2));
        System.out.println("(double) 1 / 2 = " + ((double) 1 / 2));

        int n2 = RandInt(1, 30);
        System.out.println("A random integer: " + n2);

        if (n2 > 5) {
            if (n2 > 20) {
                System.out.println(n2 + "is larger than 20");
            }
            else if (n2 > 10) {
                System.out.println(n2 + "is larger than 10");
            }
        }
        
        input.close();
    }

    public static void ComputeArea(String[] args) {
        // double radius;
        // double area;
        // final double PI = 3.14159;
    }

    public static double FahrenheitToCelsius(int F) {
        return (5.0 / 9) * (F - 32);
    }

    public static double Current(int F) {
        return (5.0 / 9) * (F - 32);
    }

    public static int RandInt(int i, int j) {
        return (int) Math.random() * (i-j) + i;
    }

    public static int RandInt(int i) {
        return (int) Math.random() * i;
    }

    public static double BMI(double w, double h) {
        return w / (h * h);
    }

    public static void WeekdayWeekend(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Weekday");
                break;
            case 0:
            case 6:
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Error !!");
        }
    }

    public static void EvenOdd(int i) {
        System.out.println(
            (i % 2 == 0) ? "num is even" : "num is odd"
        );
    }

    public static void RandomStop() {
        do {
            System.out.println("The number is smaller than 0.8");
        } while (Math.random() <= 0.8);
    }

    public static int SumFromOne(int j) {
        int sum = 0;
        for (int i=1; i <= j; i++) {
            sum += i;
        }
        return sum;
    }

    public static void RandomEven() {
        for (int i=0; i < 10; i++) {
            double j = RandInt(1, 10);
            System.out.print("Is the number even?");
            if (j % 2 == 0) {
                System.out.print(" It is !!");
            }
            else {
                continue;
            }
            System.out.println();
        }
    }
}
