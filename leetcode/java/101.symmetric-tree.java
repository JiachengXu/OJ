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
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    Stack<TreeNode> st = new Stack<>();
    st.push(root.left);
    st.push(root.right);
    while (!st.isEmpty()) {
      TreeNode right = st.pop();
      TreeNode left = st.pop();
      if (right == null && left == null)
        continue;
      if (right == null || left == null)
        return false;
      if (right.val != left.val)
        return false;
      st.push(left.right);
      st.push(right.left);
      st.push(right.right);
      st.push(left.left);
    }
    return true;
  }
}