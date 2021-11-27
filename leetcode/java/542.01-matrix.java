class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.offer(new int[]{i, j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()){
            int[] source = q.poll(); 
            for(int i = 0; i < 4; i++){
                int xx = source[0] + dx[i];
                int yy = source[1] + dy[i];
                if(xx < 0 || xx >= m || yy < 0 || yy >= n || matrix[xx][yy] <= matrix[source[0]][source[1]] + 1) continue;
                q.offer(new int[]{xx, yy});
                matrix[xx][yy] =  matrix[source[0]][source[1]] + 1;
            }
            
        }
        return matrix;
    }
}