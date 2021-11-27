class Solution {
    public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>>	res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		backtracking(res,tmp,nums);
		return res;	
    }
	void backtracking(List<List<Integer>> res, List<Integer> tmp, int[] nums){
		if(tmp.size()==nums.length){
			res.add(new ArrayList<>(tmp));
		}else {
			for(int i=0; i<nums.length; i++){
				if(!tmp.contains(nums[i])){
					tmp.add(nums[i]);
					backtracking(res,tmp,nums);
					tmp.remove(tmp.size()-1);
				}
			}
	
		}
	}
}
