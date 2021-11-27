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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> treequeue = new LinkedList<>();
        treequeue.add(root);
        int count = 1;
        while(!treequeue.isEmpty()){
            int maxv = Integer.MIN_VALUE;
            for(int i=0; i<count;i++){
                TreeNode top = treequeue.poll();
                if(top.left!=null) treequeue.add(top.left);
                if(top.right!=null) treequeue.add(top.right);
                maxv = Math.max(maxv,top.val);
            }
            count = treequeue.size();
            res.add(maxv);
        }
        return res;
    }
}