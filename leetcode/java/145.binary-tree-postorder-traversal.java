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
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> res = new LinkedList<>();
    Stack<TreeNode> st = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !st.isEmpty()) {
      if (cur != null) {
        st.push(cur);
        res.addFirst(cur.val);
        cur = cur.right;
      } else {
        cur = st.pop();
        cur = cur.left;
      }
    }
    return res;
  }
}