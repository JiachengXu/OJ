#include <algorithm>
#include <cmath>
#include <cstring>
#include <iostream>

using namespace std;

bool solve(int a) {
  if (a == 1) return false;
  int sum = 1;
  for (int i = 2; i <= sqrt(a); i++)
    if (a % i == 0 && a / i != i) sum += i + a / i;
  return sum == a;
}

int main() {
  int n, a;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (solve(a)) {
      cout << a << " is perfect" << endl;
    } else {
      cout << a << " is not perfect" << endl;
    }
  }
  return 0;
}