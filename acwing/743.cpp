#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a;
  char c;
  cin >> a;
  cin >> c;
  double m[12][12];
  for (int i = 0; i < 12; i++) {
    for (int j = 0; j < 12; j++) {
      cin >> m[i][j];
    }
  }
  double sum = 0;
  for (int i = 0; i < 12; i++) {
    sum += m[a][i];
  }
  if (c == 'S') {
    printf("%.1lf", sum);
  } else if (c == 'M') {
    printf("%.1lf", sum / 12);
  }
  return 0;
}