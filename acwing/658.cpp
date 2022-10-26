#include <algorithm>
#include <cmath>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  double a, b, c;
  cin >> a >> b >> c;
  double d = b * b - 4.0 * a * c;
  if (d < 0 || a == 0)
    printf("Impossivel calcular");
  else
    printf("R1 = %.5lf\nR2 = %.5lf", (-b + sqrt(d)) / (2.0 * a),
           (-b - sqrt(d)) / (2.0 * a));
  return 0;
}