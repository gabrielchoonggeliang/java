package Midterm;

/**
 * Question: Write a Java program that calculates the sum of all even
 * numbers between 1 and 100 using a for loop. Then, using a
 * while loop, find the sum of all odd numbers between 1 and 100.
 * Finally, use a do...while loop to calculate the average of all
 * numbers from 1 to 100. Ensure that you break out of the loops when
 * the sum of numbers reaches 100 or more.
 */

public class LectureFive {
  public static void main(String[] args) {
    int evenSum = 0;
    int oddSum = 0;
    for (int i = 1; i <= 100; i++) {
      if (i % 2 == 0) {
        evenSum += i;
      }
    }

    int count = 100;
    while (true) {
      if (count % 2 == 1) {
        oddSum += count;
        count--;
      }
      if (count == 0) {
        break;
      }
    }

    int averageSum = 0;
    int counter = 100;
    do {
      averageSum += counter;
      counter--;
    } while (counter > 0);
    counter /= 100.0;

    System.out.println(evenSum + oddSum + averageSum);
  }
}
