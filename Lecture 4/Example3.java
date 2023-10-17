import java.util.Scanner;

public class Example3 {
  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      System.out.print(args[i] + " ");
    }
    System.out.println();

    Example2.main(args);

    final int LENGTH = 5;
    int[] list1 = new int[LENGTH];
    int[] list2 = new int[list1.length]; 

    Scanner input = new Scanner(System.in);
    System.out.print("Enter " + list1.length + " values: ");
    for (int i = 0; i < list1.length; i++) {
      list1[i] = input.nextInt();
    }
    input.close();

    for (int i = 0; i < list1.length; i++) {
      list2[i] = list1[i];
    }

    for (int i = 0; i < list2.length; i++) {
      System.out.print(list2[i] + " ");
    }
  }
}