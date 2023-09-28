import java.util.Scanner;

public class ComputeLoan {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your interest rate, loan amount " +
    "and number of years for which payments will be made.");

    double interestRate = input.nextDouble();
    double loanAmount = input.nextDouble();
    short numberOfYears = input.nextShort();

    // convert interest rate to integer, and divide by 12 months
    interestRate /= (12 * 100);

    input.close();

    // formula
    double monthlyPayment = (loanAmount * interestRate) / (1 - (1 / Math.pow(1+interestRate, numberOfYears*12)));
    double totalPayment = monthlyPayment * numberOfYears * 12;
    System.out.println("Monthly payment: $" + (int)(monthlyPayment*100)/100.0 + "\nTotal payment: $" + (int)(totalPayment*100)/100.0);
  }
}
