class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        if(n == 1) return sb.toString();
        for(int j = 2; j <= n; j++){
            StringBuilder temp = new StringBuilder();
            char cur = sb.charAt(0);
            int counter = 1;
            for(int i = 1; i < sb.length(); i++){
                if(sb.charAt(i) == cur) counter ++;
                else{
                    temp.append(counter);
                    temp.append(cur);
                    cur = sb.charAt(i);
                    counter = 1;
                }
            }
            temp.append(counter);
            temp.append(cur);
            sb = new StringBuilder(temp);
        }
        return sb.toString();
    }
}