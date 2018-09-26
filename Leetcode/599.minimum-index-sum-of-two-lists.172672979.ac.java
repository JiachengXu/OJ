class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(); 
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i],i);
        }
        List<String> res = new ArrayList<>();
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                int temp = map.get(list2[i]);
                if(temp + i < sum){
                    sum = temp + i;
                    res.clear();
                    res.add(list2[i]);
                }else if(temp + i == sum){
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
