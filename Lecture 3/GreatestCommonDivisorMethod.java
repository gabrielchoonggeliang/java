import java.util.Scanner;

public class GreatestCommonDivisorMethod {
  /**
   * This program calculates the greatest common divisor of two integers entered by the user.
   * The program prompts the user to enter two integers and then displays the greatest common divisor.
   * The program uses the gcd method to calculate the greatest common divisor.
   * 
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    System.out.print("Enter first integer: ");
    int n1=input.nextInt();
    System.out.print("Enter second integer: ");
    int n2=input.nextInt();
    input.close();
    System.out.println("The greatest common divisor for "+n1+" and "+n2+" is "+gcd(n1,n2));
  }

  public static int gcd(int num1, int num2) {
    int gcd=1; // Initial gcd is 1
    int k=2; // Possible gcd

    // finding gcd
    // if divides both numbers, k is the gcd
    while(k<=num1&&k<=num2){
      if(num1%k==0&&num2%k==0)
        gcd=k;
    // try next possible gcd, until k is greater than both numbers
      k++;
    }
    return gcd;
  }
}
