public class TestCircleWithStaticMembers {
 public static void main(String[] args)  {
  System.out.println("Before creating objects");
  System.out.println("The number of Circle objects is " +
    Circle.numberOfObjects);
    
  Circle c1 = new Circle();

  System.out.println("\nAfter creating c1");
  System.out.println("c1: radius (" + c1.radius +
    ") and number of Circle objects (" +
    Circle.getNumberOfObjects() + ")");
 }
}

// New classes cannot use the public access modifier
// 
class Circle {
  double radius;

  static int numberOfObjects = 0;

  Circle () {
    radius = 1;
    numberOfObjects++;
  }

  Circle (double newRadius) {
    radius = newRadius;
    numberOfObjects++;
  }

  static int getNumberOfObjects() {
    return numberOfObjects;
  }
 
}
