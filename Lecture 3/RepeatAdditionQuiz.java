import java.util.Scanner;
/**
 * This program generates two random numbers between 0 and 9, and prompts the user to enter the sum of these two numbers.
 * If the user's answer is incorrect, the program will continue to prompt the user until the correct answer is entered.
 */
public class RepeatAdditionQuiz {
  public static void main(String[] args) {
    int number1=(int)(Math.random()*10);
    int number2=(int)(Math.random()*10);
    Scanner input=new Scanner(System.in);
    int answer=0;
    do {
      System.out.print(
        "What is "+number1+" + "+number2+"? "
        );
        answer=input.nextInt();
    } while(answer!=number1+number2);
    input.close();
  }
}