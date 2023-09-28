import java.util.Scanner;

public class SubtractionQuiz {
  public static void main(String[] args) {
    int num1 = (int)(Math.random() * 10);
    int num2 = (int)(Math.random() * 10);

    if (num1 < num2 ) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
    }

    Scanner input = new Scanner(System.in);

    System.out.print(
      "What is " + num1 + " - " + num2 + "? "
    );

    int answer = input.nextInt();
    input.close();

    if (num1 - num2 == answer)
      System.out.println("correct");
    else {
      System.out.println("wrong");
      System.out.println(num1 - num2);
    }
  }
}
