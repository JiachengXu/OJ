#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int n, tmp;
  cin >> n;
  int a1 = 0, a2 = 1;
  for (int i = 0; i < n; i++) {
    cout << a1 << " ";
    tmp = a1;
    a1 += a2;
    a2 = tmp;
  }
  return 0;
}