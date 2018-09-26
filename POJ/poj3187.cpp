#include <iostream>
#include <algorithm>

int N;
int sum;
int holder[12];
int cpholder[12];
using namespace std;

void solve() {
    cin >> N;
    cin >> sum;
    for(int i = 0; i < N; i++) {
        holder[i] = i + 1;
    }
    do {
        for(int i = 0; i < N; i++) {
            cpholder[i] = holder[i];
        }

        for(int i = N; i > 1 ; i--) {
            for(int j = 0; j < i-1; j++) {
                cpholder[j] = cpholder[j] + cpholder[j+1];
            }
        }
        if(cpholder[0] == sum) {
            for(int i = 0; i < N -1; i++) {
                cout << holder[i] << " ";
            }
            cout << holder[N - 1] << endl;
            return;
        }
    } while(next_permutation(holder,holder+N));
}

int main() {
    ios_base::sync_with_stdio(false);
    solve();
    return 0;
}
