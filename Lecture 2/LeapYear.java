
/**
 * This program checks if a given year is a leap year or not.
 * A leap year is a year that is divisible by 4 but not by 100, or is divisible by 400.
 * The program takes a year as input from the user and outputs whether it is a leap year or not.
 * @author 
 * @version 
 * @see 
 */
import java.util.Scanner;

class Leapyear {
  public static void main(String[] args) {
    //Create scanner
    Scanner input=new Scanner(System.in);
    System.out.print("Enter a year: ");
    int year=input.nextInt();
    input.close();

    //Check if leap
    boolean isLeapYear=
      (year%4==0&&year%100!=0)||(year%400==0);

    //Display result
    System.out.println(year+" is a leap year?\n> "+isLeapYear);
  }
}