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
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root == null)
      return res;
    q.add(root);
    while (!q.isEmpty()) {
      int len = q.size();
      double sum = 0;
      for (int i = 0; i < len; i++) {
        if (q.peek().left != null)
          q.add(q.peek().left);
        if (q.peek().right != null)
          q.add(q.peek().right);
        sum += q.poll().val;
      }
      res.add(sum / len);
    }
    return res;
  }
}