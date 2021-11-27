public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] solution = new int[findNums.length];
        for(int i=0;i<findNums.length;i++){
            solution[i] = -1; 
        }
        for(int k=0; k<findNums.length;k++){
            for(int i = 0; i<nums.length; i++){
                if(findNums[k] == nums[i]){
                    for(int j = i+1;j<nums.length;j++){
                        if(nums[j]>findNums[k]){
                            solution[k] = nums[j];
                            break;
                        }
                    }
                }
            }
        }
        return solution;
    }
}