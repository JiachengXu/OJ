class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<ppid.size(); i++){
            List<Integer> children = map.getOrDefault(ppid.get(i), new ArrayList<>());
            children.add(pid.get(i));
            map.put(ppid.get(i),children);
        }
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        getAllChildren(map, res, kill);
        return res;
    }
    void getAllChildren(Map<Integer, List<Integer>> map, List<Integer> children, int kill){
        if(map.containsKey(kill)){
            for(int i : map.get(kill)){
                children.add(i);
                getAllChildren(map, children, i);
            }
        }
    }
}