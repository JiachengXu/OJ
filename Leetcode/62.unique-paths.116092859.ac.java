class Solution {
    public int uniquePaths(int m, int n) {
		if(m<=0||n<=0){
			return 0;
		}
		int sum = m+n-2;
		int min = Math.min(m,n)-1;
		double res=1;
		for(int i=1;i<=min;i++){
			res=res*(sum-min+i)/i;
		}
		return (int)res;
		
    }
}

