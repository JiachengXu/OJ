class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while(i < j){
            swap(i, j, c);
            i++;
            j--;
        }
        return String.valueOf(c);
    }
    void swap(int i,int j, char[] c){
        if(c[i] != c[j]){
            char temp = c[j];
            c[j] = c[i];
            c[i] = temp;
        }
    }
}
