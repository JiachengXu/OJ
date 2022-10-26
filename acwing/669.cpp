#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
  double a;
  scanf("%lf", &a);
  if (a <= 400)
    printf("Novo salario: %.2lf\nReajuste ganho: %.2lf\nEm percentual: 15 %\n",
           a + a * 0.15, a * 0.15);
  else if (a <= 800)
    printf("Novo salario: %.2lf\nReajuste ganho: %.2lf\nEm percentual: 12 %\n",
           a + a * 0.12, a * 0.12);
  else if (a <= 1200)
    printf("Novo salario: %.2lf\nReajuste ganho: %.2lf\nEm percentual: 10 %\n",
           a + a * 0.1, a * 0.1);
  else if (a <= 2000)
    printf("Novo salario: %.2lf\nReajuste ganho: %.2lf\nEm percentual: 7 %\n",
           a + a * 0.07, a * 0.07);
  else
    printf("Novo salario: %.2lf\nReajuste ganho: %.2lf\nEm percentual: 4 %\n",
           a + a * 0.04, a * 0.04);
}