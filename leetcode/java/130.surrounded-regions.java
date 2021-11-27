class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0, -1, 0, 1};
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                if((i == 0 || i == board.length -1 || j == 0 || j == board[0].length -1) && board[i][j] == 'O'){
                    
                    dfs(board, i, j);
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'o') board[i][j] = 'O';
            }
        }
        
    }
    void dfs(char[][] board, int x , int y){
        if(x<0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] !='O') return;
        board[x][y] = 'o';
        for(int i = 0; i < 4; i++){
            int  xx = x + dx[i];
            int yy = y + dy[i];
            dfs(board, xx, yy);
        }
    } 
}