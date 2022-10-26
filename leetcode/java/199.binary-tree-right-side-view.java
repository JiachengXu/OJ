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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    lookAtRight(root, res, 0);
    return res;
  }
  void lookAtRight(TreeNode root, List<Integer> res, int depth) {
    if (root == null)
      return;
    if (depth == res.size()) {
      res.add(root.val);
    }
    lookAtRight(root.right, res, depth + 1);
    lookAtRight(root.left, res, depth + 1);
  }
}