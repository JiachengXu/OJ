#include <algorithm>
#include <cstring>
#include <iostream>

int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  printf("O JOGO DUROU %d HORA(S)", a >= b ? 24 - a + b : b - a);
  return 0;
}