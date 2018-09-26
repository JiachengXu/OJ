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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode cur = root;
        while(cur != null){
            if(cur.val > val){
                if(cur.left == null){
                    cur.left = new TreeNode(val);
                    break;
                }else cur = cur.left;
            }else{
                if(cur.right == null){
                    cur.right = new TreeNode(val);
                    break;
                }else cur = cur.right;
            }
        }
        return root;
    }
}
