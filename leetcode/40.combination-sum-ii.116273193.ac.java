class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		Arrays.sort(candidates);
		backtracking(res,tmp,candidates,target,0);
		return res;	
    }
	void backtracking(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start){
		if(target<0){
			return;
		}else if(target==0){
			res.add(new ArrayList<>(tmp));
		}else{
			for(int i = start;i<candidates.length;i++ ){
				if(i>start&&candidates[i]==candidates[i-1]){
					continue;
				}
				tmp.add(candidates[i]);
				backtracking(res,tmp,candidates,target-candidates[i],i+1);
				tmp.remove(tmp.size()-1);
			}
		}
	}
}

