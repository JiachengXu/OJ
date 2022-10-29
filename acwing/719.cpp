#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int sumOdd(int a, int b) {
  if (b <= a) {
    swap(a, b);
  }
  int sum = 0;
  for (int i = a + 1; i < b; i += 2) {
    if (a % 2 == 0) {
      sum += i;
    } else if (i + 1 < b) {
      sum += i + 1;
    }
  }
  return sum;
}

int main() {
  int n, a, b, sum;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    cin >> b;
    sum = sumOdd(a, b);
    cout << sum << endl;
  }
  return 0;
}