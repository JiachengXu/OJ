class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board.length == 0 || board[0].length == 0) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, 0, word)) return true;
            }
        }
        return false;
        
    }
    
    public boolean dfs(char[][] board, int x, int y, int index, String word){
        if(index >= word.length()){
            return true;
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return false;
        }
        char c = word.charAt(index);
        if(board[x][y] != c) return false;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean res = false;
        board[x][y] = '*';
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            res = res || dfs(board, xx, yy, index + 1, word);
            
        }
        board[x][y] = c;
        return res;
    }
}