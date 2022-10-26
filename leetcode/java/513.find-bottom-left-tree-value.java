/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public int findBottomLeftValue(TreeNode root) {
    return dfs(root, 1, new int[] {0, 0});
  }
  public int dfs(TreeNode root, int depth, int[] solution) {
    if (root == null)
      return 0;
    if (depth > solution[0]) {
      solution[0] = depth;
      solution[1] = root.val;
    }
    dfs(root.left, depth + 1, solution);
    dfs(root.right, depth + 1, solution);
    return solution[1];
  }
}