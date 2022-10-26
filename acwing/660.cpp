#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  double c[5] = {4.00, 4.50, 5.00, 2.00, 1.50};
  printf("Total: R$ %.2lf", c[a - 1] * b);
  return 0;
}