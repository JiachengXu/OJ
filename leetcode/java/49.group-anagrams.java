class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            String temp = smallest(str);
            if(map.containsKey(temp)){
                map.get(temp).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        for(List<String> a : map.values()){
            res.add(a);
        }
        return res;
    }
    String smallest(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String res = "";
        for(char cc : c){
            res += cc;
        }
        return res;
    }
}