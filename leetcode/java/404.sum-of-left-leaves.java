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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int carry = 0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            carry = root.left.val;
        }
        return carry + sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
}