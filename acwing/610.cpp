#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  string a;
  double b, c;
  cin >> a >> b >> c;
  printf("TOTAL = R$ %.2lf", b + 0.15 * c);
  return 0;
}