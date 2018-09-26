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
    Integer res = Integer.MAX_VALUE;
    Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return res;
    }
    
    void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        if(pre != null) res = Math.min(res, node.val - pre);
        pre = node.val;
        inorder(node.right);
    }
}
