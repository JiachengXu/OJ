class Solution {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int i=0;
        int len = candies.length;
        for(int n:candies){
            if(i<1||n>candies[i-1]){
                candies[i++] = n;
                if(i>len/2)return len/2;
            }
        }
        return i;
    }
}
