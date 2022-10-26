#include <algorithm>
#include <cmath>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int r;
  cin >> r;
  printf("VOLUME = %.3lf", 4 / 3.0 * 3.14159 * pow(r, 3));
  return 0;
}