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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inOrder(root, res);
    return res;
  }
  void inOrder(TreeNode node, List<Integer> res) {
    if (node == null)
      return;
    inOrder(node.left, res);
    res.add(node.val);
    inOrder(node.right, res);
  }
}