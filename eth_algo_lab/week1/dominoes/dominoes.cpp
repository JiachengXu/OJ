#include <algorithm>
#include <iostream>

using namespace std;
int N;
int num;
int counter;
int dis;
int dominoes[1000005];

void solve() {
  cin >> num;
  counter = 0;
  dis = 0;
  for (int i = 0; i < num; i++) {
    cin >> dominoes[i];
  }
  for (int i = 0; i < num; i++) {
    if (i <= dis) {
      dis = max(dis, i + dominoes[i] - 1);
      counter++;
    } else {
      cout << counter << endl;
      return;
    }
  }
  cout << num << endl;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin >> N;
  for (int i = 0; i < N; i++) {
    solve();
  }
  return 0;
}
