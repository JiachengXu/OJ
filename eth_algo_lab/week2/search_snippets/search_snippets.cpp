#include <algorithm>
#include <iostream>
#include <unordered_map>
using namespace std;

void solve() {
  int n;
  cin >> n;
  int len = 0;
  int lens[n];
  for (int i = 0; i < n; i++) {
    cin >> lens[i];
    len += lens[i];
  }
  int nums[len];
  unordered_map<int, int> map;
  int j = 0;
  int sum = lens[0];
  for (int i = 0; i < len; i++) {
    cin >> nums[i];
    if (i >= sum) {
      j++;
      sum += lens[j];
    }
    map[nums[i]] = j;
  }
  sort(nums, nums + len);
  int res = 1 << 30;
  int start = 0;
  unordered_map<int, int> curmap;
  curmap[map[nums[start]]] = 0;
  for (int i = 1; i < len; i++) {
    int temp = map[nums[i]];
    curmap[temp] = i;
    while (curmap.find(map[nums[start]]) != curmap.end() &&
           curmap[map[nums[start]]] != start) {
      start++;
    }
    if (curmap.size() == n) {
      if (nums[i] - nums[start] + 1 < res) {
        res = nums[i] - nums[start] + 1;
      }
    }
  }
  cout << res << endl;
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
