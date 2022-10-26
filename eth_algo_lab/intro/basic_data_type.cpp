#include <iomanip>
#include <iostream>
#include <string>

using namespace std;
int t;
int n1;
long n2;
string n3;
double n4;

void solve() {
  cin >> n1 >> n2 >> n3 >> n4;
  cout << n1 << ' ' << n2 << ' ' << n3 << ' ' << setprecision(2) << fixed << n4
       << endl;
}
int main() {
  cin >> t;
  for (int i = 0; i < t; i++) solve();
  return 0;
}
