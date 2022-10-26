#include <algorithm>
#include <iostream>

using namespace std;

int t;
string a;
string b;
void solve() {
  cin >> a;
  cin >> b;
  cout << a.length() << ' ' << b.length() << endl;
  cout << a + b << endl;
  reverse(a.begin(), a.end());
  reverse(b.begin(), b.end());
  char temp = a[0];
  a[0] = b[0];
  b[0] = temp;
  cout << a << ' ' << b << endl;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin >> t;
  for (int i = 0; i < t; i++) solve();
  return 0;
}
