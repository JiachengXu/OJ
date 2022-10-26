#include <algorithm>
#include <iostream>
#include <sstream>

using namespace std;

const int INF = 100000000;
int N;
int holder[12];
int res;

int difference(int i, int j) { return abs(i - j); }

void p(int last) {
  do {
    int mid = last / 2;
    if ((mid != 1 && holder[0] == 0) || (last != 2 && holder[mid] == 0))
      continue;
    int first, second;
    first = 0;
    second = 0;
    for (int i = 0; i < mid; i++) {
      first = 10 * first + holder[i];
    }
    for (int i = mid; i < last; i++) {
      second = 10 * second + holder[i];
    }
    res = min(res, difference(first, second));
  } while (next_permutation(holder, holder + last));
}

void solve() {
  cin >> N;
  cin.get();
  for (int i = 0; i < N; i++) {
    int j = 0;
    res = INF;
    string line;
    getline(cin, line);
    istringstream iss(line);
    while (iss >> holder[j]) {
      j++;
    }
    p(j);
    cout << res << endl;
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  solve();
  return 0;
}
