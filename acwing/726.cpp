#include <algorithm>
#include <cmath>
#include <cstring>
#include <iostream>

using namespace std;

bool isPrime(int a) {
  if (a == 1) return false;
  for (int i = 2; i <= sqrt(a); i++) {
    if (a % i == 0) return false;
  }
  return true;
}

int main() {
  int n, a;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    cout << a << (isPrime(a) ? " is prime" : " is not prime") << endl;
  }
  return 0;
}