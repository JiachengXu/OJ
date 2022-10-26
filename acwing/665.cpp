#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  printf("%s",
         (a % b == 0 || b % a == 0) ? "Sao Multiplos" : "Nao sao Multiplos");
  return 0;
}