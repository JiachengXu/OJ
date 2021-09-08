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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res,root,sb);
        return res;
    }
    void dfs(List<String> res, TreeNode root, StringBuilder sb){
        if(root==null) return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            res.add(sb.toString());
        }else{
            sb.append("->");
            dfs(res,root.left,sb);
            dfs(res,root.right,sb);
        }
        sb.setLength(len);
    }
}
