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
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> res = new ArrayList<>();
    helper(root, new HashMap<>(), res);
    return res;
  }

  String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
    if (node == null)
      return "#";
    String serial =
        node.val + "," + helper(node.left, map, list) + "," + helper(node.right, map, list);
    if (map.getOrDefault(serial, 0) == 1)
      list.add(node);
    map.put(serial, map.getOrDefault(serial, 0) + 1);
    return serial;
  }
}