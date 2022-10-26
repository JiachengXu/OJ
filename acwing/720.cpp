#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a, n;
  cin >> a;
  while (cin >> n && n <= 0) {
  }
  cout << (a + a + n - 1) * n / 2 << endl;
  return 0;
}