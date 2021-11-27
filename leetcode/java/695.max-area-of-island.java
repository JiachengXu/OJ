class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i ,j));
                }
            }
        }
        return res;
        
    }
    int dfs(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) return 0;
        int[] dx  = {1 , 0 , -1, 0};
        int[] dy = {0, 1, 0, -1};
        int res = 1;
        grid[x][y] = 0;
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            res += dfs(grid, xx ,yy);
        }
        return res;
    }
}