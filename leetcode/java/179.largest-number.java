class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0) return "";
        String[] snums = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            snums[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String string1, String string2){
                String s1 = string1+string2;
                String s2 = string2+string1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(snums,comp);
        if(snums[0].charAt(0)=='0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : snums){
            sb.append(s);
        }
        return sb.toString();
    }
}