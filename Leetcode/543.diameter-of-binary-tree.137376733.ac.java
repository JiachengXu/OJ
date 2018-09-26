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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1; 
        dfs(root);
        return ans-1;
    }
    int dfs(TreeNode root){
        if(root==null) return 0;
        int L = dfs(root.left);
        int R = dfs(root.right);
        ans = Math.max(ans,L+R+1);
        return Math.max(L,R) + 1;
    }
}
