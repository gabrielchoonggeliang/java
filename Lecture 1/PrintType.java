public class PrintType {
    public static void main(String[] args) {
        // The println() method simply prints a new line character after the initial print() method
        // print() method will not print a new line to the console
        System.out.print("Welcome to Java");
        System.out.print("\n");

        // println() is equivalent to print() and print("\n")
        System.out.print("Welcome ");
        System.out.print("to ");
        System.out.print("Java");

        // formatted print statement is more versatile in decimal point manipulation
        int radius = 5;
        System.out.printf("The radius is %d", radius);
        System.out.println();
        System.out.print("The radius is " + radius);
    }
}