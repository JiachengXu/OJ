class Solution {
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for(int num : nums){
            Node cur = root;
            for(int i = 31; i >= 0 ; i--){
                int bit = (num >> i) & 1;
                if(cur.children[bit] == null){
                    cur.children[bit] = new Node();
                }
                cur = cur.children[bit];
            }
        }
        int res = Integer.MIN_VALUE;
        for(int num : nums){
            Node cur = root;
            int temp = 0;
            for(int i = 31; i >= 0; i--){
                int bit = (num >> i) & 1;
                if(cur.children[bit ^ 1] != null){
                    temp += 1 << i;
                    cur = cur.children[bit ^ 1];
                }else{
                    cur = cur.children[bit];
                }
                
            }
            res = Math.max(res, temp);
        }
        return res;
        
    }
    class Node{
        Node[] children = new Node[2];
    }
}
