import java.util.Scanner;

public class nextVSnextLine {
 public static void main (String[] args) {
  // Declare the boject and initialise with
  // predefined standard input object
  Scanner sc = new Scanner(System.in);
  
  // Taking input
  String name = sc.nextLine();
  char gender = sc.next().charAt(0);
  int age = sc.nextInt();
  
  sc.nextLine(); // Consume newline left-over

  String fatherName = sc.nextLine();
  String motherName = sc.nextLine();

  // Print the values to check
  // if the input was correctly obtained
  System.out.println("Name: "+name);
  System.out.println("Gender: "+gender);
  System.out.println("Age: "+age);
  System.out.println("Father's Name: "+fatherName);
  System.out.println("Mother's Name: "+motherName);
  sc.close();
 }
}