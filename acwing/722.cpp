#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a, b, sum = 0;
  while (cin >> a && cin >> b && a > 0 && b > 0) {
    if (b < a) swap(a, b);
    for (int i = a; i <= b; i++) {
      cout << i << " ";
      sum += i;
    }
    cout << "Sum=" << sum << endl;
    sum = 0;
  }
  return 0;
}