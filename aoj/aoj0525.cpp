#include <iostream>

using namespace std;
const int MaxR = 11;
const int MaxC = 10001;
int pan[MaxR][MaxC];
int res;
int ans;
int R;
int C;

void dfs(int k) {
  if (k == R) {
    res = 0;
    for (int i = 0; i < C; i++) {
      int sum = 0;
      for (int j = 0; j < R; j++) {
        if (pan[j][i]) sum++;
      }
      res += max(sum, R - sum);
    }
    ans = max(res, ans);
    return;
  }
  dfs(k + 1);
  for (int i = 0; i < C; i++) {
    pan[k][i] = 1 - pan[k][i];
  }
  dfs(k + 1);
}

void solve() {
  ans = 0;
  for (int i = 0; i < R; i++) {
    for (int j = 0; j < C; j++) {
      cin >> pan[i][j];
    }
  }
  dfs(0);
}

int main() {
  ios_base::sync_with_stdio(false);
  while (cin >> R >> C && R > 0 && C > 0) {
    solve();
    cout << ans << endl;
  }
  return 0;
}
