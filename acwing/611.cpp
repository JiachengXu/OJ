#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a, b, c, d;
  double x, y;
  scanf("%d%d%lf%d%d%lf", &a, &b, &x, &c, &d, &y);
  printf("VALOR A PAGAR: R$ %.2lf", b * x + d * y);
  return 0;
}