class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> hash;
        vector<int> res;
        for(int i=0; i<nums.size(); i++){
            int number = target - nums[i];
            if(hash.find(number) != hash.end()){
                res.push_back(hash[number]);
                res.push_back(i);
                return res;
            }
            hash[nums[i]] = i;
        }
    }
};