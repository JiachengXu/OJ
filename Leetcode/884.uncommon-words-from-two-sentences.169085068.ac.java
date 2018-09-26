class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Map<String, Integer> container = new HashMap<String,Integer>();
        for(String aa: a){
            if(container.containsKey(aa)){
                container.put(aa, container.get(aa) + 1);
            }else{
                container.put(aa, 1);
            }
        }
        for(String aa: b){
            if(container.containsKey(aa)){
                container.put(aa, container.get(aa) + 1);
            }else{
                container.put(aa, 1);
            }
        }
        List<String> l = new ArrayList<>();
        for(String key: container.keySet()){
            if(container.get(key) == 1){
                l.add(key);
            }
        }
        String[] res = new String[l.size()];
        res = l.toArray(res);
        return res;
    }
}
