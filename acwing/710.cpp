#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int x;
  cin >> x;
  for (int i = 0; i < 6; i++) {
    if (x % 2 == 0) {
      cout << x + 1 + 2 * i << endl;
    } else {
      cout << x + 2 * i << endl;
    }
  }
  return 0;
}