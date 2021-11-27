class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] flagcol = new boolean[n];
        boolean[] flag45 = new boolean[2 * n - 1];
        boolean[] flag135 = new boolean[2 * n - 1];
        helper(res, flagcol, flag45, flag135, 0, board);
        return res;
    }
    public void helper(List<List<String>> res, boolean[] flagcol, boolean[] flag45, boolean[] flag135,int row, char[][] board){
        if(row == board.length){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                String r = new String(board[i]);
                temp.add(r);
            }
            res.add(temp);
        }else{
            for(int i = 0; i < board[0].length; i++){
                if(!flagcol[i] && !flag45[i + row] && !flag135[board[0].length - 1 - row + i]){
                    flagcol[i] = true;
                    flag45[i + row] = true;
                    flag135[board[0].length - 1 - row + i] = true;
                    board[row][i] = 'Q';
                    helper(res, flagcol, flag45,flag135, row + 1, board);
                    flagcol[i] = false;
                    flag45[i + row] = false;
                    flag135[board[0].length - 1 - row + i] = false;
                    board[row][i] = '.';
                }
            }
        }
    }
}