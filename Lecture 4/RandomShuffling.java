import java.util.Arrays;

public class RandomShuffling {
  public static void main(String[] args) {
    int[] myList = {1, 2, 3, 4, 5};
    
    // Fisher-Yates shuffle algorithm
    for (int i = 0; i < myList.length - 1; i++) {
      int j = (int) (Math.random() * (myList.length - i));
      int temp = myList[i];
      myList[i] = myList[j];
      myList[j] = temp;
    }
    // Before shifting
    System.out.println(Arrays.toString(myList));
    
    // Shift elements by 1
    int temp = myList[myList.length - 1];
    for (int i = myList.length - 1; i > 0; i--) {
      myList[i] = myList[i - 1];
    }
    myList[0] = temp;
    
    System.out.println(Arrays.toString(myList));
  }
}
