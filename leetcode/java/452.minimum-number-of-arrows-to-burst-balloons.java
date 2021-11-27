class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int res = 1;
        int pos = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(pos >= points[i][0]) continue;
            else{
                res++;
                pos = points[i][1];
            }
        }
        return res;
    }
}