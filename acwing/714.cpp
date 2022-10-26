#include <algorithm>
#include <cmath>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a, b;
  cin >> a >> b;
  int l = min(a, b);
  int r = max(a, b);
  int sum = 0;
  for (int i = l + 1; i < r; i++) {
    if (i % 2 != 0) sum += i;
  }
  cout << sum << endl;
  return 0;
}