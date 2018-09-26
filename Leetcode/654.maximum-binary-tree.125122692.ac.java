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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    TreeNode buildTree(int[] nums, int i, int j){
        if(i>j) return null;
        int max = Integer.MIN_VALUE;
        int index = 1001;
        for(int k=i;k<=j;k++){
            if(nums[k]>max){
                max = nums[k];
                index = k;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = buildTree(nums,i,index-1);
        node.right = buildTree(nums,index+1,j);
        return node;  
    }
}
