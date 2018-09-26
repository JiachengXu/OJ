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
    public TreeNode pruneTree(TreeNode root) {
        return containsOnes(root)? root : null;
    }
    boolean containsOnes(TreeNode root){
        if(root == null) return false;
        boolean left = containsOnes(root.left);
        boolean right = containsOnes(root.right);
        if(!left) root.left = null;
        if(!right) root.right = null;
        return root.val == 1 || left || right;
    }
}
