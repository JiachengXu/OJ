class Solution {
    public int thirdMax(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Integer one = null;
        Integer two = null;
        Integer three = null;
        for(Integer n:nums){
            if(n.equals(one)||n.equals(two)||n.equals(three)) continue;
            if(one==null||n>one){
                three = two;
                two = one;
                one = n;
            }else if(two==null||n>two){
                three = two;
                two = n;
            }else if(three==null||n>three){
                three = n;
            }
        }
        return three==null?one:three;
    }
}
