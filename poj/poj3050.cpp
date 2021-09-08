#include <iostream>
#include <set>

using namespace std;
int grid[6][6];
set<int> se;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};

void dfs(int x, int y, int num, int step){
	if(step == 5){
		se.insert(num);
		return;
	}
	for(int i = 0; i < 4; i++){
		int xx = x + dx[i];
		int yy = y + dy[i];
		if(xx >= 0 && xx < 5 && yy >= 0 && yy <5){
			dfs(xx, yy, 10 * num + grid[xx][yy], step +1);
		}
	}
}
int main(){
	ios_base::sync_with_stdio(false);
	for (int i = 0; i < 5; ++i) {
		for (int j = 0;j < 5; ++j) {
			cin >> grid[i][j];
		}
	}
	for (int i = 0; i < 5; ++i) {
		for (int j = 0;j < 5; ++j) {
			dfs(i, j,grid[i][j] , 0);
		}
	}
	cout << se.size() << endl;
	return 0;
}
