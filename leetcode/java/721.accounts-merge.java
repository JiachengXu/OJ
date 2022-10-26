class Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n = accounts.size();
    UF uf = new UF(n);
    Map<String, Integer> map = new HashMap<>();
    Map<Integer, String> owner = new HashMap<>();
    for (int i = 0; i < accounts.size(); i++) {
      owner.put(i, accounts.get(i).get(0));
      for (int j = 1; j < accounts.get(i).size(); j++) {
        String email = accounts.get(i).get(j);
        if (map.containsKey(email)) {
          uf.union(map.get(email), i);
        } else {
          map.put(email, i);
        }
      }
    }

    Map<Integer, TreeSet<String>> unions = new HashMap<>();
    for (int i = 0; i < accounts.size(); i++) {
      int root = uf.root(i);
      if (!unions.containsKey(root)) {
        unions.put(root, new TreeSet<>());
      }
      for (int j = 1; j < accounts.get(i).size(); j++) {
        unions.get(root).add(accounts.get(i).get(j));
      }
    }

    List<List<String>> res = new ArrayList<>();
    for (Integer idx : unions.keySet()) {
      List<String> temp = new ArrayList<>();
      temp.add(owner.get(idx));
      for (String email : unions.get(idx)) temp.add(email);
      res.add(temp);
    }
    return res;
  }
  class UF {
    int[] parent;
    int[] rank;
    public UF(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) parent[i] = i;
    }

    int root(int i) {
      while (parent[i] != i) {
        i = parent[i];
      }
      return i;
    }

    void union(int i, int j) {
      int r1 = root(i);
      int r2 = root(j);
      if (r1 == r2)
        return;
      if (rank[r1] > rank[r2])
        parent[r2] = r1;
      else if (rank[r1] < rank[r2])
        parent[r1] = r2;
      else {
        parent[r1] = r2;
        rank[r2]++;
      }
    }
  }
}