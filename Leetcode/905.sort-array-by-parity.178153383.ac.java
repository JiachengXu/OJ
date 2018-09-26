class Solution {
    public int[] sortArrayByParity(int[] A) {
        int j = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0) {
                swap(i, j ,A);
                j++;
            }
            
        }
        return A;
    }
    void swap(int i , int j , int[] A){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
