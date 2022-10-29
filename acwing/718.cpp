#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int n, num = 0;
  cin >> n;
  int c = 0, r = 0, f = 0;
  char x;
  for (int i = 0; i < n; i++) {
    cin >> num;
    cin >> x;
    if (x == 'C') {
      c += num;
    } else if (x == 'F') {
      f += num;
    } else if (x == 'R') {
      r += num;
    }
  }
  cout << "Total: " << c + r + f << " animals" << endl;
  cout << "Total coneys: " << c << endl;
  cout << "Total rats: " << r << endl;
  cout << "Total frogs: " << f << endl;
  printf("Percentage of coneys: %.2lf %\n", ((double)100 * c) / (c + r + f));
  printf("Percentage of rats: %.2lf %\n", ((double)100 * r) / (c + r + f));
  printf("Percentage of frogs: %.2lf %\n", ((double)100 * f) / (c + r + f));
  return 0;
}