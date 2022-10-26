#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a[4];
  for (int i = 0; i < 4; i++) cin >> a[i];
  if (a[1] > a[2] && a[3] > a[0] && a[0] + a[1] < a[2] + a[3] && a[2] > 0 &&
      a[3] > 0 && a[0] % 2 == 0)
    cout << "Valores aceitos" << endl;
  else
    cout << "Valores nao aceitos" << endl;
  return 0;
}