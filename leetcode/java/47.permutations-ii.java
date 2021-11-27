class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>>	res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		backtracking(res,tmp,nums,used);
		return res;		
    }
	void backtracking(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used){
		if(tmp.size()==nums.length){
			res.add(new ArrayList<>(tmp));
		}else{
			for(int i = 0; i< nums.length;i++){
				if(used[i]==true){
					continue;
				}
				if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false){
					continue;
				}
					tmp.add(nums[i]);
					used[i] = true;
					backtracking(res,tmp,nums,used);
					used[i] = false;
					tmp.remove(tmp.size()-1);
				}
			}
		}
	}
