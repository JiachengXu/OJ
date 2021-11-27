public class Solution {
    public int change(int amount, int[] coins) {
        int[][] solution = new int[amount+1][coins.length+1];
        for(int i=0;i<coins.length+1;i++){
            solution[0][i]=1;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                solution[j][i] = (j>=coins[i-1] ? solution[j-coins[i-1]][i] : 0)+solution[j][i-1];
            }
        }
    return solution[amount][coins.length];
    }
}