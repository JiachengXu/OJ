#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int n, m;
  cin >> n;
  int in = 0, out = 0;
  for (int i = 0; i < n; i++) {
    cin >> m;
    if (10 <= m && m <= 20) {
      in++;
    } else {
      out++;
    }
  }
  cout << in << " in" << endl;
  cout << out << " out" << endl;
  return 0;
}