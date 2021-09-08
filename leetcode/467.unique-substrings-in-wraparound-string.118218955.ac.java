class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] nums = new int[26];
        int maxnums = 0;
        int len = p.length();
        for(int i = 0; i< len;i++){
            if(i>0&&(p.charAt(i)-p.charAt(i-1)==1||p.charAt(i-1)-p.charAt(i)==25)){
                maxnums++;
            }else{
                maxnums = 1;
            }
            int index = p.charAt(i)-'a';
            nums[index] = Math.max(nums[index],maxnums);
        }
        int sum = 0;
        for(int n:nums){
            sum+=n;
        }
        return sum;
    }
}
