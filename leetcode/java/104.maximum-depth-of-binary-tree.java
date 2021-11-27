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
    public int maxDepth(TreeNode root) {
        return maxDepth2(root);
    }
    
    int maxDepth2(TreeNode node){
        if(node == null) return 0;
        int left = maxDepth2(node.left);
        int right = maxDepth2(node.right);
        return Math.max(left, right) + 1;
    }
}