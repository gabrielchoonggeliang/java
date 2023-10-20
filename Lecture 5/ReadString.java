import java.util.Scanner;

public class ReadString {
  public static void main(String[] args ) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter three words separated by spaces: ");
    String s1 = input.next();
    String s2 = input.next();
    String s3 = input.next();
    System.out.println("s1 is " + s1);
    System.out.println("s2 is " + s2);
    System.out.println("s3 is " + s3);

    input.nextLine(); // consume the new line
    
    System.out.print("Enter a line of text: ");
    String s4 = input.nextLine();
    System.out.println("s4 is " + s4);

    char i = s4.charAt(3);
    System.out.println("The character at index 3 is " + i);
    input.close();
  }
}