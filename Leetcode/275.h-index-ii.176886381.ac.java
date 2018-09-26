class Solution {
    public int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length - 1;
        int len = citations.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(citations[mid] == len - mid + 1 ){
                return len - mid + 1;
            }else if(citations[mid] > len - mid + 1){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return len - l + 1; 
    }
}
