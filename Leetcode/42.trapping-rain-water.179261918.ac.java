class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1; 
        int res = 0;
        if(height == null || height.length < 3) return res;
        while(l < r &&height[l] < height[l+1]) l++;
        while(l < r && height[r] < height[r - 1]) r--;
        while(l < r){
            int left = height[l];
            int right = height[r];
            if(left < right){
                l++;
                while(l < r && left > height[l]){
                    res += left - height[l];
                    l++;
                }
            }else{
                r--;
                while(l < r && right > height[r]){
                    res += right - height[r];
                    r--;
                }
            }
        }
        return res;
    }
}
