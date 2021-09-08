class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int n = s.length(); 
        int l = words.length;
        if(n == 0 || l == 0) return res;
        int m = words[0].length();
        for(int i = 0; i <n - l * m + 1; i++){
            int j = 0;
            Map<String, Integer> seen = new HashMap<>();
            while(j < l){
                String word = s.substring(i + j * m, i + (j + 1) * m);
                if(map.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word,0)+ 1);
                    if(seen.get(word) > map.get(word)) break;
                }else break;
                j++;
            }
            if(j == l) res.add(i);
        }
        return res;
    }
}
