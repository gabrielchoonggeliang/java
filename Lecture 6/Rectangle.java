public class Rectangle {
  
  // data fields
  double width;
  double height;

  // constructors
  Rectangle() {

    // default values
    width = 1;
    height = 1;
  }

  Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  double getArea() {
    return this.width * this.height;
  }

  double getPerimeter() {
    return 2 * (this.width + this.height);
  }

  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(4, 40);
    Rectangle r2 = new Rectangle(3.5, 35.9);

    // Display width height area and perimeter using print
    System.out.print("Rectangle 1: " + r1.width + " " + r1.height + " " + r1.getArea() + " "
        + r1.getPerimeter() + "\n");

    System.out.print("Rectangle 2: " + r2.width + " " + r2.height + " " + r2.getArea() + " "
        + r2.getPerimeter() + "\n");
  }
}
