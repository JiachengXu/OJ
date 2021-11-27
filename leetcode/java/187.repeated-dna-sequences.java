class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> counter = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i <= s.length() - 10 ;i++){
            String temp = s.substring(i, i+10);
            if(counter.containsKey(temp) && counter.get(temp) == 1) res.add(temp);
            counter.put(temp, counter.getOrDefault(temp ,0) + 1);
        }
        return res;
    }
}