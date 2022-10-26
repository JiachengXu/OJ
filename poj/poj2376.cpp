#include <algorithm>
#include <iostream>
using namespace std;
const int max_N = 25001;
pair<int, int> cows[max_N];

int N;
int T;
int res;

void solve() {
  res = 0;
  cin >> N;
  cin >> T;
  for (int i = 0; i < N; i++) {
    cin >> cows[i].first;
    cin >> cows[i].second;
  }
  sort(cows, cows + N);
  int end = 1;
  int i = 0;
  while (end <= T) {
    int nextend = -1;
    for (; i < N; i++) {
      if (cows[i].first <= end) {
        nextend = max(nextend, cows[i].second);
      } else {
        break;
      }
    }
    if (nextend == -1) {
      cout << -1 << endl;
      return;
    } else {
      end = nextend + 1;
      res++;
    }
    if (end > T) {
      cout << res << endl;
      return;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  solve();
  return 0;
}
