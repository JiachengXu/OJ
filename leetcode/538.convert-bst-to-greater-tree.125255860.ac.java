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
    int runningSum;
    public TreeNode convertBST(TreeNode root) {
        runningSum = 0;
        reverseInOrder(root);
        return root;
    }
    void reverseInOrder(TreeNode root){
        if(root == null) return;
        reverseInOrder(root.right);
        int temp = root.val;
        root.val+=runningSum;
        runningSum+=temp;
        reverseInOrder(root.left);
    }
}
