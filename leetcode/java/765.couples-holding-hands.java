class Solution {
  public int minSwapsCouples(int[] row) {
    int n = row.length / 2;
    UF uf = new UF(n);
    for (int i = 0; i < n; i++) {
      int a = row[2 * i];
      int b = row[2 * i + 1];
      uf.union(a / 2, b / 2);
    }
    return n - uf.count;
  }
  class UF {
    int[] parent;
    int[] rank;
    int count;
    public UF(int n) {
      count = n;
      rank = new int[n];
      parent = new int[n];
      for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
      while (parent[x] != x) {
        x = parent[x];
      }
      return x;
    }

    void union(int x, int y) {
      int r1 = find(x);
      int r2 = find(y);
      if (r1 == r2)
        return;
      if (rank[r1] > rank[r2]) {
        parent[r2] = r1;
      } else if (rank[r1] < rank[r2]) {
        parent[r1] = r2;
      } else {
        parent[r1] = r2;
        rank[r2]++;
      }
      count--;
    }
  }
}