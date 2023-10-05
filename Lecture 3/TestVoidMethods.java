public class TestVoidMethods {
/**
 * This program demonstrates the usage of the printGrade method to print the corresponding letter grade for a given score.
 * The main method calls the printGrade method twice with different scores.
 * 
 * @param args the command-line arguments as an array of strings
 */
 public static void main(String[] args) {
  System.out.print("The grade is ");
  printGrade(78.5);

  System.out.print("\nThe grade is ");
  printGrade(59.5);
 }

 public static void printGrade(double score) {
  if(score<0||score>100) return;
  if(score>=90.0) System.out.print('A');
  else if(score>=80.0) System.out.print('B');
  else if(score>=70.0) System.out.print('C');
  else if(score>=60.0) System.out.print('D');
  else System.out.print('F');
 }
}
