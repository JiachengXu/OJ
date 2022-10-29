#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i += 2) {
    string s((n - i) / 2, ' ');
    string t(i, '*');
    cout << s << t << s << endl;
  }
  for (int i = n - 2; i >= 1; i -= 2) {
    string s((n - i) / 2, ' ');
    string t(i, '*');
    cout << s << t << s << endl;
  }
  return 0;
}