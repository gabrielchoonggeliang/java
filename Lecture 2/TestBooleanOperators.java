/**
 * The TestBooleanOperators program implements an application that
 * checks if a given integer is divisible by 2 and 3, divisible by 2 or 3,
 * or divisible by 2 or 3 but not both. The program takes an integer input
 * from the user and outputs the results of the checks.
 *
 * This program uses the Scanner class to read user input from the console.
 * The program then uses conditional statements with logical operators to
 * check if the input integer is divisible by 2 and 3, divisible by 2 or 3,
 * or divisible by 2 or 3 but not both. The program then outputs the results
 * of the checks to the console.
 *
 * @author 
 * @version 
 * @see 
 */

import java.util.Scanner;

public class TestBooleanOperators {
  public static void main(String[] args) {
    Scanner input=new Scanner(System.in);

    System.out.print("Enter an integer: ");
    int number=input.nextInt();

    if(number%2==0&&number%3==0)
      System.out.println(number+" is divisible by 2 and 3.");

    if(number%2==0||number%3==0)
      System.out.println(number+" is divisible by 2 or 3.");

    if(number%2==0^number%3==0)
      System.out.println(number+" is divisible by 2 or 3, but not both.");

    input.close();
  }
}
