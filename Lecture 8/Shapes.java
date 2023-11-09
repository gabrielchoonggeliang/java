public class Shapes {
  public void area () {
    System.out.println("The formula for area of ");
  }
  public static void main(String[] args) {
    Shapes myShape = new Shapes();
    Shapes myTriangle = new Triangle();
    Shapes myCircle = new Circle();

    myShape.area();
    myTriangle.area();
    myShape.area();
    myCircle.area();
  }
}

class Triangle extends Shapes {
  @Override
  public void area () {
    System.out.println("Triangle is 1/2 * base * height");
  }
}

class Circle extends Shapes {
  @Override
  public void area () {
    System.out.println("Circle is 3.14 * radius * raidus ");
  }
}