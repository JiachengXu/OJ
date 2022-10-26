#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  double a, b, c;
  double tmp;
  cin >> a >> b >> c;
  if (b >= a && b >= c) {
    tmp = a;
    a = b;
    b = c;
    c = tmp;
  } else if (c >= a && c >= b) {
    tmp = a;
    a = c;
    c = b;
    b = tmp;
  }
  if (a >= b + c) {
    cout << "NAO FORMA TRIANGULO" << endl;
  } else if (a * a == b * b + c * c) {
    cout << "TRIANGULO RETANGULO" << endl;
  } else if (a * a < b * b + c * c) {
    cout << "TRIANGULO ACUTANGULO" << endl;
  } else if (a * a > b * b + c * c) {
    cout << "TRIANGULO OBTUSANGULO" << endl;
  }
  if (a == b && b == c) {
    cout << "TRIANGULO EQUILATERO" << endl;
  } else if (a == b || b == c || a == c) {
    cout << "TRIANGULO ISOSCELES" << endl;
  }
  return 0;
}