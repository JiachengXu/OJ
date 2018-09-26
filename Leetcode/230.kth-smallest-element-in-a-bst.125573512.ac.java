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
    int res = 0;
    int knum;
    public int kthSmallest(TreeNode root, int k) {
        knum = k;
        inOrder(root);
        return res;
    }
    void inOrder(TreeNode root){
        if(root==null) return ;
        inOrder(root.left);
        knum--;
        if(knum==0){
            res = root.val;
            return;
        }
        inOrder(root.right);
    }
}
