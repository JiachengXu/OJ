#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  double m[12][12];
  double sum = 0;
  int cnt = 0;
  char c;
  cin >> c;
  for (int i = 0; i < 12; i++) {
    for (int j = 0; j < 12; j++) {
      cin >> m[i][j];
      if (j + i < 11 && i < j) {
        sum += m[i][j];
        cnt++;
      }
    }
  }
  printf("%.1lf", c == 'S' ? sum : sum / cnt);
  return 0;
}