class Solution {
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for(int i = 0; i < M.length; i++){
            for(int j = i + 1; j < M[0].length; j++){
                if(M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
    
    class UnionFind{
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int n){
            rank = new int[n];
            parent = new int[n];
            count = n;
            for(int i = 0; i < n; i++) parent[i] = i;
        }
        
        int root(int x){
            while(parent[x] != x){
                x = parent[x];
            }
            return x;
        }
        
        void union(int i , int j){
            int rooti = root(i);
            int rootj = root(j);
            if(rooti == rootj) return;
            if(rank[rooti] > rank[rootj]){
                parent[rootj] = rooti;
            }else if(rank[rooti] < rank[rootj]){
                parent[rooti] = rootj;
            }else{
                parent[rooti] = rootj;
                rank[rooti]++;
            }
            count--;
        }
    }
}