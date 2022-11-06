#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  double x;
  for (int i = 0; i < 100; i++) {
    cin >> x;
    if (x <= 10) {
      printf("A[%d] = %.1lf\n", i, x);
    }
  }
  return 0;
}