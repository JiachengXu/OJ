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
  public int rob(TreeNode root) {
    if (root == null)
      return 0;
    int[] res = helper(root);
    return Math.max(res[1], res[0]);
  }

  int[] helper(TreeNode node) {
    int[] res = new int[2];
    if (node == null)
      return res;
    int[] left = helper(node.left);
    int[] right = helper(node.right);
    int with = node.val + left[0] + right[0];
    int without = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return new int[] {without, with};
  }
}