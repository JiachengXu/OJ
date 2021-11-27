class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            int num = map.getOrDefault(word, 0)+1;
            map.put(word, num);
        }
        
        Queue<String> heap = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return map.get(s1) != map.get(s2) ? map.get(s1) - map.get(s2) : s2.compareTo(s1);
            }
        });
        for (String word: map.keySet()){
            heap.add(word);
            if(heap.size() > k){
                heap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!heap.isEmpty()){
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}