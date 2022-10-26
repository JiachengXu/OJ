#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int z = max(a, max(b, c));
  int x = min(a, min(b, c));
  int y = a + b + c - x - z;
  cout << x << endl;
  cout << y << endl;
  cout << z << "\n" << endl;
  cout << a << endl;
  cout << b << endl;
  cout << c << endl;
  return 0;
}