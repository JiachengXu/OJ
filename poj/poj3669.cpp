#include <iostream>
#include <queue>

using namespace std;
const int MaxM = 50000;
const int MaxX = 300;
const int MaxY = 300;
const int MaxT = 1000;
const int INF  = 100000;
int M;
int ma[MaxY+10][MaxX+10];
int t[MaxY+10][MaxX+10];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0, -1};
int res;
typedef pair<int, int> P;

int dfs(){
    queue<P> que;
    que.push(P(0,0));
    for(int i = 0; i < MaxY + 10; i++){
        for(int j = 0; j < MaxX + 10; j++){
            t[i][j] = -1; 
        }
    }
    t[0][0] = 0;
    while(que.size()){
        P p = que.front();
        que.pop();
        int x = p.first;
        int y = p.second;
        if(ma[y][x] == INF){
            return t[y][x];
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && 0 <= ny && nx <MaxX +10 && ny < MaxY + 10 && t[ny][nx] == -1 && ma[ny][nx] > t[y][x] +1){
                t[ny][nx] = t[y][x] + 1;
                que.push(P(nx, ny));
            }
        }
        
    }
    return -1;
}

void solve(){
    res = 0;
    for(int i = 0; i < MaxY + 10; i++){
        for(int j = 0; j < MaxX + 10; j++){
            ma[i][j] = INF;
        }
    }
    cin >> M;
    for(int i = 0; i < M; i++){
        int x ,y, time;
        cin >> x >> y >> time;
        ma[y][x] = min(ma[y][x], time);
        for(int j = 0; j < 4; j++){
            int xx = x + dx[j];
            int yy = y + dy[j];
            if(xx>=0 && yy >= 0){
                ma[yy][xx] = min(ma[yy][xx], time);
            }
        }
    }
    cout << dfs() << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    solve();
    return 0;
}
