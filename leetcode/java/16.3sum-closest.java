class Solution {
    public int threeSumClosest(int[] nums, int target) {
		if(nums == null && nums.length <=2){
			return 0;
		}
		int res = Integer.MAX_VALUE;
		int error = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for(int i = 0;i<nums.length-2;i++){
			int j = i+1;
			int k = nums.length-1;
			while(j<k){
				int sum = nums[i]+nums[j]+nums[k];
				if((sum-target)>=error){
					k--;
				}else if((sum-target)<=-error){
					j++;
				}else{
					res = sum;
					if(sum - target>0){
						error = sum-target;
						k--;
					}else{
						error = target-sum;
						j++;
					}
				}
			}
		}
		return res;		
    }
}
