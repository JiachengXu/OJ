#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  double a, b;
  scanf("%lf%lf", &a, &b);
  printf("MEDIA = %.5lf", (a * 3.5 + b * 7.5) / 11);
}