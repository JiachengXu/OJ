#include <math.h>

#include <iostream>

using namespace std;

void solve() {
  int n;
  int k;
  int ii;
  int jj;
  int summ = 1 << 30;

  cin >> n;
  cin >> k;
  int sum[n + 1];
  int temp;

  sum[0] = 0;
  for (int i = 1; i <= n; i++) {
    cin >> temp;
    sum[i] = sum[i - 1] + temp;
  }

  // for(int i = 0; i < n; i++){
  // for(int j = i + 1; j <= n; j++){
  // long temp = sum[j] - sum[i];
  // if(temp == k){
  // cout << i << ' ' << j - 1 << endl;
  // return;
  //}else if(abs(k - temp) < abs(k - summ)){
  // summ = temp;
  // ii = i;
  // jj = j - 1;
  //}
  //}
  //}
  int i = 0;
  int j = 1;

  while (i <= n && j <= n) {
    int tempsum = sum[j] - sum[i];
    if (abs(k - tempsum) < abs(k - summ)) {
      summ = tempsum;
      ii = i;
      jj = j - 1;
    }
    if (tempsum == k) {
      break;
    } else if (tempsum > k) {
      i++;
    } else {
      j++;
    }
  }
  cout << ii << ' ' << jj << endl;
}

int main() {
  int t;
  ios_base::sync_with_stdio(false);
  cin >> t;
  for (int i = 0; i < t; i++) {
    solve();
  }
  return 0;
}
