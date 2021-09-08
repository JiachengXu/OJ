class Solution {
    public int[][] generateMatrix(int n) {
        if(n<0) return null;
        int[][] res = new int[n][n];
        if(n==0) return res;
        int h1 = 0;
        int h2 = n-1;
        int l1 = 0;
        int l2 = n-1;
        int curr = 1;
        while(h1<=h2&&l1<=l2){
            for(int i=l1;i<=l2;i++){
                res[h1][i] = curr;
                curr++;
            }
            
            for(int i=h1+1;i<=h2;i++){
                res[i][l2]=curr;
                curr++;
            }
            if(h1<h2&&l1<l2){
                for(int i=l2-1;i>l1;i--){
                    res[h2][i]=curr;
                    curr++;
                }
                for(int i=h2;i>h1;i--){
                    res[i][l1]=curr;
                    curr++;
                }
            }
            h1++;
            h2--;
            l1++;
            l2--;
        }
        return res;
    }
}
