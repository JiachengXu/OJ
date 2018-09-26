class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left;i<=right;i++){
            if(isSDN(i)){
                res.add(i);
            }
        }
        return res;
    }
    
    public boolean isSDN(int n){
        if(n<10) return true;
        int m = n;
        while(m!=0){
            int dig = m%10;
            if(dig==0) return false;
            if(n%dig!=0){
                return false;
            }
            m=m/10;
        }
        return true;
    }
}
