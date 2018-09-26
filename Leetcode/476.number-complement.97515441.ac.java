public class Solution {
    public int findComplement(int num) {
        int bound = (int)Math.floor(Math.log(num)/Math.log(2));
        for(int i=bound+1;i<32;i++){
            num |= 1<<i; 
        }
        return ~num;
    }
}
