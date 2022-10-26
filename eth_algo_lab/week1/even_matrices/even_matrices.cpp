#include <iostream>

using namespace std;

int m[205][205];
int prefix[205][205];
int colsum[205];
int n;
int t;
int even;
int odd;
int sum;
int res;

void solve() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      cin >> m[i][j];
    }
  }

  for (int i = 0; i <= n; i++) {
    prefix[i][0] = 0;
    prefix[0][i] = 0;
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      prefix[i][j] =
          m[i][j] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
    }
  }

  res = 0;
  for (int i1 = 1; i1 <= n; i1++) {
    for (int i2 = i1; i2 <= n; i2++) {
      even = 0;
      odd = 0;
      sum = 0;
      for (int j = 1; j <= n; j++) {
        colsum[j] = prefix[i2][j] - prefix[i2][j - 1] - prefix[i1 - 1][j] +
                    prefix[i1 - 1][j - 1];
        sum += colsum[j];
        if (sum % 2 == 0)
          even++;
        else
          odd++;
      }
      res += (odd * (odd - 1)) / 2 + (even * (even - 1)) / 2 + even;
    }
  }
  cout << res << endl;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin >> t;
  for (int i = 0; i < t; i++) {
    solve();
  }
  return 0;
}
