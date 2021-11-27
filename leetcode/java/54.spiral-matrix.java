class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new ArrayList<>(); 
        List<Integer> res = new ArrayList<>();
        int rowh =  matrix.length - 1;
        int colr =  matrix[0].length - 1;
        int rowl = 0;
        int coll = 0;
        while(rowl <= rowh && coll <= colr){
            for(int i = coll; i <= colr; i++){
                res.add(matrix[rowl][i]);
            }
            rowl++;
            for(int i = rowl; i <= rowh; i++){
                res.add(matrix[i][colr]);
            }
            colr--;
            if(rowl <= rowh){
                
            for(int i = colr; i >=  coll; i--){
                res.add(matrix[rowh][i]);
            }
            rowh--;
            }
            if(coll <= colr){
                for(int i = rowh; i >= rowl; i--){
                    res.add(matrix[i][coll]);
                }
                coll++;
                
            }
        }
        return res;
        
            
    }
}