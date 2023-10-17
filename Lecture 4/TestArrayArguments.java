/**
 * This class demonstrates the use of array arguments in Java methods.
 * It also shows that arrays are passed by reference in Java.
 */
public class TestArrayArguments {
  public static void main(String[] args) {
    int x=1; //x represents an int value
    int[] y=new int[10]; //y represents an array of int values

    y[0]=1;
    System.out.println("Before m method, x is "+x);
    System.out.println("Before m method, y[0] is "+y[0]);

    m(x,y); //Invoke m with arguments x and y

    System.out.println("x is "+x);
    System.out.println("y[0] is "+y[0]);

  }

  /**
   * This method takes an int and an array of ints as arguments, and assigns new values to them.
   * @param number an int value to be assigned a new value
   * @param numbers an array of int values to be assigned a new value
   */
  public static void m(int number, int[] numbers) {
    number=1001; //Assign a new value to number
    numbers[0]=5555; //Assign a new value to numbers[0]
  }
}
