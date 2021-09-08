class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c: tasks){
            map[c-'A']++;
        }
        Arrays.sort(map);
        int max_val = map[25]-1;
        int slot = max_val*n;
        for(int i = 24;i>=0;i--){
            slot-=Math.min(max_val,map[i]);
        }
        return slot>0?slot+tasks.length:tasks.length;
    }
}
