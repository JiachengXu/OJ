class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        int ctr1 = 0;
        int ctr2 = 0;
        int num1 = nums[0];
        int num2 = nums[0];
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(num1==nums[i]){
                ctr1++;
            }else if(num2==nums[i]){
                ctr2++;
            }else if(ctr1==0){
                num1 = nums[i];
                ctr1=1;
            }else if(ctr2==0){
                num2 = nums[i];
                ctr2=1;
            }else{
                ctr1--;
                ctr2--;
            }
        }
        ctr1 = 0;
        ctr2 = 0;
        for(int i=0;i<len;i++){
            if(nums[i]==num1){
                ctr1++;
            }else if(nums[i]==num2){
                ctr2++;
            }
        }
        if(ctr1>len/3){
            res.add(num1);
        }
        if(num2!=num1&&ctr2>len/3){
            res.add(num2);
        }
        return res;
    }
}
