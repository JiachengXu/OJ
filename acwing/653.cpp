#include <algorithm>
#include <cstring>
#include <iostream>

int main() {
  int cash[7] = {100, 50, 20, 10, 5, 2, 1};
  int a;
  scanf("%d", &a);
  printf("%d\n", a);
  for (int i = 0; i < 7; i++) {
    printf("%d nota(s) de R$ %d,00\n", a / cash[i], cash[i]);
    a = a % cash[i];
  }
  return 0;
}