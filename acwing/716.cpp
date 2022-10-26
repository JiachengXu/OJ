#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int m = -1;
  int a;
  int idx;
  for (int i = 1; i <= 100; i++) {
    cin >> a;
    if (a > m) {
      m = a;
      idx = i;
    }
  }
  cout << m << endl;
  cout << idx << endl;
  return 0;
}