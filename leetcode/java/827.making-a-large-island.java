class Solution {
    int res = -1;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] seen;
    public int largestIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    seen = new boolean[grid.length][grid[0].length];
                    res = Math.max(res, dfs(grid, i ,j,seen));
                    grid[i][j] = 0;
                }
            }
        }
        return res == -1 ? grid.length * grid[0].length : res;
    }
    
    int dfs(int[][] grid, int x, int y, boolean[][] seen){
        if(x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || grid[x][y] != 1 || seen[x][y]) return 0;
        int res = 1;
        seen[x][y] = true;
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            res += dfs(grid, xx, yy, seen);
        }
        return res;
    }
}