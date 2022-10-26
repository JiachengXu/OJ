#include <iostream>

using namespace std;
int N;
int num;
int sum;

void solve() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> num;
    sum = 0;
    for (int j = 0; j < num; j++) {
      int temp = 0;
      cin >> temp;
      sum += temp;
    }
    cout << sum << endl;
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  solve();
  return 0;
}
