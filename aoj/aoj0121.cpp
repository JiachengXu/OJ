#include <iostream>
#include <queue>
#include <map>
#include <string>

using namespace std;

map<string, int> holder;
int d[4] = {1,-1,4,-4};
int in[8];

void dfs(){
    queue<string> que;
    holder["01234567"] = 0;
    que.push("01234567");
    while(que.size()){
        string cur = que.front();
        que.pop();
        int p = cur.find("0");
        for(int i = 0; i < 4; i++){
            int np = p + d[i];
            if(0<= np && np < 8 && (p !=3 || d[i] != 1) && (p != 4 || d[i] != -1)){
                string next = cur;
                next[p] = cur[np];
                next[np] = '0';
                if(holder.find(next) == holder.end()){
                    holder[next] = holder[cur] + 1;
                    que.push(next);
                }
            }
        }

    }
}

void solve(){
    dfs();
    while(cin >> in[0]){
        for(int i = 1; i < 8; i++){
            cin >> in[i];
        }
        string sol = "";
        for(int i = 0; i < 8; i++){
            sol += in[i] + '0';
        }
        if(holder.find(sol) == holder.end()){
            cout << -1 << endl;
        }else{
            cout << holder[sol] << endl;
        }
    }    
}

int main(){
    ios_base::sync_with_stdio(false);
    solve();
    return 0;
} 
