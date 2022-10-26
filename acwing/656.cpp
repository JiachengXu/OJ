#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  double aa;
  int b[12] = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5, 1};
  cin >> aa;
  long a = (long)(aa * 100);
  for (int i = 0; i < 12; i++) {
    if (i == 0) {
      printf("NOTAS:\n");
    } else if (i == 6) {
      printf("MOEDAS: \n");
    }

    if (i < 6) {
      printf("%d nota(s) de R$ %.2lf\n", a / b[i], b[i] / 100.0);
    } else {
      printf("%d moeda(s) de R$ %.2lf\n", a / b[i], b[i] / 100.0);
    }
    a %= b[i];
  }
  return 0;
}