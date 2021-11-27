class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] map = new int[10];
        //row
        for(int i = 0; i < 9 ; i++){
            map = new int[10];
            for(int j = 0; j < 9 ; j++){
                if(board[i][j] != '.'){
                    if(map[board[i][j] - '0'] != 0) return false;
                    map[board[i][j] - '0'] ++;
                }
            }
        }
        //col
        for(int i = 0; i < 9; i++){
            map = new int[10];
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    if(map[board[j][i] - '0'] != 0) return false;
                    map[board[j][i] - '0'] ++;
                }
            }
        }
        
        //3*3
        int[] x = {0,3,6,9};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                map = new int[10];
                int start = x[i];
                int end = x[i+1];
                int start2 = x[j];
                int end2 = x[j+1];
                for(int l = start; l < end; l++){
                    for(int m = start2; m < end2; m++){
                        if(board[l][m] != '.'){
                            if(map[board[l][m] - '0'] != 0) return false;
                            map[board[l][m] - '0'] ++;
                        }
                    }
                }
            }
        }
        return true;
    }
}