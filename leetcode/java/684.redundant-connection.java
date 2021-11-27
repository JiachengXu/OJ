class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(1001);
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0] - 1;
            int y = edges[i][1] - 1;
            if(!uf.union(x, y)){
                return edges[i];
            }
        }
        return new int[2];
    }
    
    class UF{
        int[] parent;
        int[] rank;
        public UF(int n){
            rank = new int[n];
            parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }
        int root(int i){
            while(parent[i] != i){
                i = parent[i];
            }
            return i;
        }
        
        boolean union(int i, int j){
            int rooti = root(i);
            int rootj = root(j);
            if(rooti == rootj) return false;
            if(rank[rooti] > rank[rootj]) parent[rootj] = rooti;
            else if(rank[rooti] < rank[rootj]) parent[rooti] = rootj;
            else{
                parent[rooti] = rootj;
                rank[rooti]++;
            }
            return true;
        }
    }
}