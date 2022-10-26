/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;
    int max = 0;
    int min = 0;
    Queue<TreeNode> nodes = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    nodes.add(root);
    cols.add(0);
    while (!nodes.isEmpty()) {
      TreeNode temp = nodes.poll();
      int col = cols.poll();
      if (!map.containsKey(col)) {
        map.put(col, new ArrayList<>());
      }
      map.get(col).add(temp.val);
      if (temp.left != null) {
        nodes.add(temp.left);
        cols.add(col - 1);
        min = Math.min(min, col - 1);
      }
      if (temp.right != null) {
        nodes.add(temp.right);
        cols.add(col + 1);
        max = Math.max(max, col + 1);
      }
    }
    for (int i = min; i <= max; i++) {
      res.add(map.get(i));
    }
    return res;
  }
}