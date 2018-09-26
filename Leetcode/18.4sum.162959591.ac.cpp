class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> res;
        if(nums.size() <= 3) return res;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < nums.size() - 3; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                threeSum(nums,res,target - nums[i],i);
            }
        }
        return res;
        
    }
    void threeSum(vector<int>& nums,vector<vector<int>>& res,int target2, int idx) {
        for(int i = idx+1; i < nums.size() - 2; i++){
            if(i == idx+1 || (i > idx+1 && nums[i] != nums[i-1])){
                int l = i + 1;
                int r = nums.size() - 1;
                int target = target2 - nums[i];
                while(l < r){
                    if(nums[l] + nums[r] == target){
                        res.push_back({nums[idx],nums[i],nums[l],nums[r]});
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(nums[l] + nums[r] < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
    }
};
