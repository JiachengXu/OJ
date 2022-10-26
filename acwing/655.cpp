#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int N;
  cin >> N;
  cout << N / 365 << " ano(s)\n"
       << N % 365 / 30 << " mes(es)\n"
       << N % 365 % 30 << " dia(s)" << endl;
  return 0;
}