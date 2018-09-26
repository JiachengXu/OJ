class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0) return res;
        for(int i=0;i<nums1.length&&i<k;i++){
            que.offer(new int[]{nums1[i],nums2[0],0});
        }
        while(k>0&&!que.isEmpty()){
            int[] curr = que.poll();
            res.add(new int[]{curr[0],curr[1]});
            k--;
            if(curr[2]==nums2.length-1) continue;
            que.offer(new int[]{curr[0],nums2[curr[2]+1],curr[2]+1});
        }
        return res;
    }
}
