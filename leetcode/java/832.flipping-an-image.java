class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int row = 0; row < A.length; row++){
            for(int col = 0; col < (A[0].length + 1) / 2; col++){
                reverse(row,col,A[0].length - 1- col, A);
            }
            
        }
        return A;
        
    }
    
    public void reverse(int row, int col1, int col2, int[][] A){
        int temp = A[row][col1];
        A[row][col1] = 1 - A[row][col2];
        A[row][col2] = 1 - temp;
        

    }
}