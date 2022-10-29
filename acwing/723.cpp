#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int n, m;
  int k = 1;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (j == m - 1) {
        cout << "PUM" << endl;
      } else {
        cout << k << " ";
      }
      k++;
    }
  }
  return 0;
}