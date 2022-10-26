#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  double x;
  cin >> x;
  if (x <= 2000)
    printf("Isento");
  else if (x <= 3000)
    printf("R$ %0.2lf", (x - 2000) * 0.08);
  else if (x <= 4500)
    printf("R$ %0.2lf", 80 + (x - 3000) * 0.18);
  else
    printf("R$ %0.2lf", 80 + 270 + (x - 4500) * 0.28);
  return 0;
}