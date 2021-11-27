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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return helper(postorder, postorder.length - 1, inorder, 0, postorder.length - 1);
    }
    
    TreeNode helper(int[] postorder, int idx, int[] inorder, int start, int end){
        if( start > end || idx < 0) return null;
        TreeNode node = new TreeNode(postorder[idx]);
        int i = 0;
        for(i = start; i <= end; i++){
            if(inorder[i] == node.val){
                break;
            }
        }
        node.right = helper(postorder, idx - 1, inorder, i + 1, end);
        node.left = helper(postorder,idx - (end - i + 1), inorder, start, i - 1);
        return node;
    }
}