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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.right == null && node.left == null && node.val == sum) return true;
            if(node.right != null){
                node.right.val += node.val;
                st.push(node.right);
            }
            if(node.left != null){
                node.left.val += node.val;
                st.push(node.left);
            }
        }
        return false;
    }
}