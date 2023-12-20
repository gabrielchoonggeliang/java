/**
 * The TestEdible class is used to test the implementation of the Edible and Animal interfaces.
 * It contains a main method that creates an array of objects and iterates through them to check if they are instances of Edible or Animal.
 * If an object is an instance of Edible, it calls the howToEat method and prints the result.
 * If an object is an instance of Animal, it calls the sound method and prints the result.
 */
public class TestEdible {
  public static void main(String[] args) {
    Object[] objects = {new Tiger(), new Chicken(), new Apple()};
    for (int i = 0; i < objects.length; i++) {
      if (objects[i] instanceof Edible)
        System.out.println(((Edible)objects[i]).howToEat());

      if (objects[i] instanceof Animal) {
        System.out.println(((Animal)objects[i]).sound());
      }
    }
  }
}

/**
 * The Animal class is an abstract class that represents an animal.
 * It contains a private instance variable weight, and getter and setter methods for weight.
 * It also contains an abstract method sound() that returns a String representing the sound the animal makes.
 */
abstract class Animal {
  private double weight;

  public double getWeight() {
    return weight;
  }

  public void setWeight (double weight) {
    this.weight = weight;
  }

  public abstract String sound();
}

/**
 * The Edible interface is implemented by classes that represent food items that can be eaten.
 */
abstract interface Edible {
  public abstract String howToEat();
}

/**
 * This class represents a Chicken which is an Animal and implements the Edible interface.
 */
class Chicken extends Animal implements Edible {
  @Override
  public String howToEat() {
    return "Chicken: Fry it";
  }

  @Override
  public String sound() {
    return "Chicken: cock-a-doodle-doo";
  }
}

/**
 * Tiger class represents a type of Animal that makes the sound "Tiger: ROOAARR".
 */
class Tiger extends Animal {
  @Override
  public String sound() {
    return "Tiger: ROOAARR";
  }
}

/**
 * This is an abstract class that represents a fruit which is edible.
 */
abstract class Fruit implements Edible {

}

/**
 * This class represents an Apple, which is a type of Fruit.
 * It overrides the howToEat method to return instructions on how to make apple cider.
 */
class Apple extends Fruit {
  @Override
  public String howToEat() {
    return "Apple: Make apple cider";
  }
}

/**
 * Represents an Orange fruit that can be consumed by making orange juice.
 */
class Orange extends Fruit {
  @Override
  public String howToEat() {
    return "Orange: Make orange juice";
  }
}