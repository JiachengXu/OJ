class Solution {
  public int[] findRedundantDirectedConnection(int[][] edges) {
    int[] parent = new int[1001];
    for (int i = 0; i < parent.length; i++) parent[i] = i;
    int[] c1 = null;
    int[] c2 = null;
    for (int[] edge : edges) {
      int r1 = find(parent, edge[0] - 1);
      int r2 = find(parent, edge[1] - 1);
      if (r1 != r2) {
        if (r2 != edge[1] - 1)
          c1 = edge;
        else
          parent[r2] = r1;
      } else
        c2 = edge;
    }
    if (c1 == null)
      return c2;
    if (c2 == null)
      return c1;

    for (int[] e : edges) {
      if (e[1] == c1[1])
        return e;
    }

    return new int[2];
  }

  private int find(int[] parent, int i) {
    while (parent[i] != i) {
      i = parent[i];
    }
    return i;
  }
}