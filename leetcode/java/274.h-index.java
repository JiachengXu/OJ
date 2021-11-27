class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] array = new int[len + 1];
        for(int i = 0; i < len; i++){
            if(citations[i] > len){
                array[len] += 1;
            }else{
                array[citations[i]] += 1;
            }
        }
        
        int counter = 0;
        for(int i = len; i >= 0; i--){
            counter += array[i];
            if(counter >= i){
                return i;
            }
        }
        return 0;
    }
}