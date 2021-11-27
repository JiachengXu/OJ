class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for(int a : A){
            Set<Integer> cur2 = new HashSet<>();
            cur2.add(a);
            for(Integer i : cur){
                cur2.add(i | a);
            }
            res.addAll(cur2);
            cur = cur2;
        }
        return res.size();
    }
}