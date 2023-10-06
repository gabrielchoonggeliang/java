import java.util.Scanner;
public class Palindrome {
  public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    String userInput=input.nextLine();
    input.close();
    int low=0;
    int high=userInput.length()-1;

    boolean isPalindrome=true;
    while(low<high){
      if(Character.toLowerCase(userInput.charAt(low))!=Character.toLowerCase(userInput.charAt(high))){
        isPalindrome=false;
        break;
      }
      low++;
      high--;
    }

    if(isPalindrome) System.out.println("Palindrome");
    else System.out.println("Not a palindrome");
  }
}
