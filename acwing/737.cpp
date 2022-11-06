#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int x;
  for (int i = 0; i < 10; i++) {
    cin >> x;
    printf("X[%d] = %d\n", i, x <= 0 ? 1 : x);
  }
  return 0;
}