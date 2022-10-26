#include <iostream>

using namespace std;

const int MAX_W = 20;
const int MAX_H = 20;
int map[MAX_H][MAX_W];
int w, h;
const int INF = 11;
int sx, sy;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int ans;

void dfs(int x, int y, int num) {
  if (num >= 10) {
    return;
  }
  int xx, yy;
  for (int i = 0; i < 4; i++) {
    xx = x;
    yy = y;
    while (1) {
      xx += dx[i];
      yy += dy[i];
      if (xx < 0 || xx >= w || yy < 0 || yy >= h) {
        break;
      }
      if (map[yy][xx] == 3) {
        ans = min(ans, num + 1);
        break;
      }
      if (map[yy][xx] == 1) {
        map[yy][xx] = 0;
        int py = yy - dy[i];
        int px = xx - dx[i];
        if (py != y || px != x) {
          dfs(px, py, num + 1);
        }
        map[yy][xx] = 1;
        break;
      }
    }
  }
}

void solve() {
  ans = INF;
  for (int i = 0; i < h; i++) {
    for (int j = 0; j < w; j++) {
      cin >> map[i][j];
      if (map[i][j] == 2) {
        sx = j;
        sy = i;
      }
    }
  }
  dfs(sx, sy, 0);
  if (ans == INF) {
    ans = -1;
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  while (cin >> w >> h && w > 0 && h > 0) {
    solve();
    cout << ans << endl;
  }
  return 0;
}
