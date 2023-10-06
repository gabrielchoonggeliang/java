import java.util.Scanner;


/**
 * This program prompts the user to enter an integer between 1 and 10, 
 * and then prints all the integers from 1 to the user input, except for 3 and 7.
 */
public class Example_1 {
 public static void main(String[] args) {
  Scanner input=new Scanner(System.in);
  System.out.print("Enter integer between 1 and 10: ");
  int userInput=input.nextInt();
  input.close();

  if(userInput<1||userInput>10) return;
  for(int i=1;i<=userInput;i++){
    if(i==3||i==7) continue;
    System.out.println(i);
  }
 }
}