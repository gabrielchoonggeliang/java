import java.util.Scanner;

public class CountLetters {
  public static int countLetters(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i)))
        count++;
    }
    return count;
  }

  public static void main (String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();
    System.out.println("The number of letters in the string is " + countLetters(s));
    input.close();
  }
}