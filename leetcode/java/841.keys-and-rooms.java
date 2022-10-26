class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> set = new HashSet<Integer>();
    dfs(0, set, rooms);
    return set.size() == rooms.size();
  }
  void dfs(int room, Set<Integer> visited, List<List<Integer>> rooms) {
    if (visited.contains(room))
      return;
    visited.add(room);
    for (int key : rooms.get(room)) {
      dfs(key, visited, rooms);
    }
  }
}