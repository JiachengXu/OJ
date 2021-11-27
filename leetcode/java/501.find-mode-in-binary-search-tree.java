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
    int[] modes; 
    int modeCount = 0;
    int curCount = 0;
    int curVal = 0;
    int max = 0;
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        curCount = 0;
        curVal = 0;
        modeCount = 0;
        inorder(root);
        return modes;
    }
    
    private void handle(TreeNode node){
        if(node.val != curVal){
            curVal = node.val; 
            curCount = 0;
        }
        curCount++;
        if(curCount > max){
            max = curCount;
            modeCount = 1;
        }else if(curCount == max){
            if(modes != null){
                modes[modeCount] = curVal;
            }
            modeCount++;
        }
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        handle(root);
        inorder(root.right);
    }
}