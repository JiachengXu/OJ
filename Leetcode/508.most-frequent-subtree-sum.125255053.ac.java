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
    Map<Integer,Integer> map;
    int maxcount;
    public int[] findFrequentTreeSum(TreeNode root) {
        maxcount = 0;
        map = new HashMap<>();
        postOrder(root);
        List<Integer> res = new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==maxcount) res.add(key);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
        
    }
    int postOrder(TreeNode root){
        if(root==null) return 0;
        int left =postOrder(root.left);
        int right = postOrder(root.right);
        int sum = root.val+left+right;
        int count = map.getOrDefault(sum,0)+1;
        map.put(sum,count);
        maxcount = Math.max(maxcount,count);
        return sum;
    }
}
