import java.util.Scanner;

public class ReadNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a byte value:");
        byte byteValue = input.nextByte();

        System.out.println("Enter a short value:");
        short shortValue = input.nextShort();

        System.out.println("Enter an int value:");
        int intValue = input.nextInt();

        System.out.println("Enter a long value:");
        long longValue = input.nextLong();

        System.out.println("Enter a float value:");
        float floatValue = input.nextFloat();

        input.close();

        System.out.printf("%d %d %d %d %f", byteValue, shortValue, intValue, longValue, floatValue);
    }
}