#include<iostream>
using namespace std;
int W, H, ans;
char tiles[20][20]; 
int dx[4] = {1,0,-1,0}; 
int dy[4] = {0,1,0, -1}; 
void dfs(int y, int x){ 
	if(tiles[y][x] != '.') return;
	ans++;
	tiles[y][x] = '#';
	for(int i = 0; i < 4; i++){
		int xx = x + dx[i]; 
		int yy = y + dy[i];
		if(xx < W && xx >= 0 && yy >= 0 && yy < H){
			dfs(yy,xx);
		}
	}

}

void solve(){
	ans = 0;
	for(int i = 0; i < H; i++){
		for(int j = 0; j < W; j++){
			cin >> tiles[i][j];

		}
	}
	for(int i = 0; i < H; i++){
		for(int j = 0; j < W; j++){
			if(tiles[i][j] == '@'){
				tiles[i][j] = '.';
				dfs(i, j);
				return;
			}
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	while(cin >> W >> H && W > 0 && H > 0){
		solve();
		cout << ans << endl;
	}
	return 0;
}
