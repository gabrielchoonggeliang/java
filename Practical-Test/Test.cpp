#include <iostream>

class Test {
private:
  int a, b, c;

public:
  Test(int a, int b, int c) {
    a = ++b - c--;
  }

  int getA() {
    return a;
  }

  int getB() {
    return b -= a * c;
  }

  bool isEqual(int a, int b) {
    return a == b;
  }
};

int main(void) {

  int a = 10, b = 20, c = b - a;
  Test object = Test(3, 4, 5);

  std::cout << object.isEqual(a , b) << std::endl;
  std::cout << object.isEqual(a , c) << std::endl;
  if (object.isEqual(a, b))
    std::cout << "what";
  else
    std::cout << ":D";

  std::cout << "\n";
}