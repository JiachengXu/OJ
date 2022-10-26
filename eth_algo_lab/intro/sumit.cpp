#include <iostream>

using namespace std;
int sum;
int n;
int t;
int temp;

void solve() {
  sum = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    sum += temp;
  }
  cout << sum << endl;
}

int main() {
  cin >> t;
  for (int i = 0; i < t; i++) {
    solve();
  }
  return 0;
}
