class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		backtracking(res,tmp,nums,0);
		return res;		
    }
	void backtracking(List<List<Integer>> res, List<Integer> tmp, int[] nums,int start){
		res.add(new ArrayList<>(tmp));
			for(int i = start; i<nums.length; i++){
				tmp.add(nums[i]);
				backtracking(res,tmp,nums,i+1);
				tmp.remove(tmp.size()-1);
			}
	} 
}

