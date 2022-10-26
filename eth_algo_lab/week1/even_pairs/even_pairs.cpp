#include <algorithm>
#include <iostream>

using namespace std;
int N;
int num;
int temp;
int even;
int odd;
int sum;

void solve() {
  cin >> num;
  even = 0;
  odd = 0;
  sum = 0;
  for (int i = 0; i < num; i++) {
    cin >> temp;
    sum += temp;
    if (sum % 2 == 0)
      even++;
    else
      odd++;
  }
  cout << (odd * (odd - 1)) / 2 + (even * (even - 1)) / 2 + even << endl;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin >> N;
  for (int i = 0; i < N; i++) {
    solve();
  }
  return 0;
}
