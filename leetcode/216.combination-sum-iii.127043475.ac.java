class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(res,temp,n,k,1);
        return res;
    }
    
    void backtracking(List<List<Integer>> res, List<Integer> temp, int n, int k, int start){
        if(temp.size()==k&&n==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=9;i++){
            temp.add(i);
            backtracking(res,temp,n-i,k,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
