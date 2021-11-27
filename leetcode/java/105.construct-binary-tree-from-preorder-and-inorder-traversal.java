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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    TreeNode helper(int[] preorder, int idx, int[] inorder, int start, int end){
        if(start > end || idx >= preorder.length) return null;
        TreeNode node = new TreeNode(preorder[idx]);
        int i = 0;
        for(i = start; i <= end; i++){
            if(inorder[i] == node.val) break;
        }
        node.left = helper(preorder, idx + 1, inorder, start, i - 1);
        node.right = helper(preorder, idx + (i - start) + 1, inorder, i + 1, end );
        return node;
    }
}