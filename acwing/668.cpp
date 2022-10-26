#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  int a, b, c, d;
  cin >> a >> b >> c >> d;
  int mins;
  if (a < c) {
    mins = (c - a) * 60 + (d - b);
  } else if (a == c) {
    if (d > b) {
      mins = d - b;
    } else {
      mins = 24 * 60 + (d - b);
    }
  } else {
    mins = (24 + c - a) * 60 + (d - b);
  }
  printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)", mins / 60, mins % 60);
  return 0;
}