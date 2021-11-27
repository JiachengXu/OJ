class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};
    int res = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return res;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j, grid);
                    res++;
                }
            }
        }
        return res;
    }
    
    void dfs(int x, int y, char[][] grid){
        if(x < 0 || x >=  grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') return; 
        grid[x][y] = '0';
        for(int i = 0; i < 4; i++){
            dfs(x + dx[i], y + dy[i], grid);
        }
    }
}
