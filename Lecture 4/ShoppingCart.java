public class ShoppingCart {
  public static void main(String[] args) {
    double totalPrice = calculateTotalPrice(19.99, 29.99, 9.95, 5.49, 14.99);

    System.out.println("Total Price: $" + totalPrice); // Output: Total Price: $80.41
  }

  public static double calculateTotalPrice(Double ... items) {
    double tmp = 0;
    for (double i : items) {
      tmp += i;
   }
    return Math.round(tmp * 100.0) / 100.0;
  }
}