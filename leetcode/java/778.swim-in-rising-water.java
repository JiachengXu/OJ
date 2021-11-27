class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        UF uf = new UF(n * n);
        int time = 0;
        while(!uf.connected(0, n * n - 1)){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] > time) continue;
                    if(i < n - 1 && grid[i + 1][j] <= time) uf.union(i * n + j, i * n + j + n);
                    if(j < n - 1 && grid[i][j + 1] <= time) uf.union(i * n + j, i * n + j + 1);
                }
            }
            time++;
        }
        return time - 1;
    }
    
    class UF{
        int[] parent;
        int[] rank;
        public UF(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }
        
        int root(int x){
            while(parent[x] != x){
                x = parent[x];
            }
            return x;
        }
        
        boolean connected(int x, int y){
            return root(x) == root(y);
        }
        
        void union(int x , int y){
            int r1 = root(x);
            int r2 = root(y);
            if(r1 == r2) return;
            if(rank[r1] > rank[r2]) parent[r2] = r1;
            else if(rank[r1] < rank[r2]) parent[r1] = r2;
            else{
                parent[r1] = r2;
                rank[r2]++;
            }
        }
    }
}