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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode cur = root;
        while((cur.val - p.val) * (cur.val - q.val) > 0){
            if(cur.val > p.val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return cur;
    }
}
