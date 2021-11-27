class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] pac;
    boolean[][] atl;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        pac = new boolean[m][n];
        atl = new boolean[m][n];
        for(int i = 0; i < m; i++){
            dfs(matrix, i, 0, pac, -1);
            dfs(matrix, i, n - 1, atl, -1);
        }
        for(int j = 0; j < n; j++){
            dfs(matrix, 0, j, pac, -1);
            dfs(matrix, m - 1, j, atl, -1);
        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && atl[i][j]){
                    int[] temp = {i ,j};
                    res.add(temp);
                }
            }
        }
        return res;
    }
    
    void dfs(int[][] matrix, int x, int y, boolean[][] seen, int value){
        if(x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1 || value > matrix[x][y] || seen[x][y] ) return;
        seen[x][y] = true;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                dfs(matrix, xx, yy, seen, matrix[x][y]);
            }
        }
    }
    

}