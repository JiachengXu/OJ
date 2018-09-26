public class Solution {
    public int[] countBits(int num) {
        int[] solution = new int[num+1];
        solution[0] = 0;
        for(int i=1;i<=num;i++){
            if(i%2==0){
                solution[i] = solution[i/2];
            }else{
                solution[i] = solution[(i/2)]+1;
            }
        }
    return solution;
    }
}
