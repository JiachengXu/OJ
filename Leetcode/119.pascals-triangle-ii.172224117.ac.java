class Solution {
    public List<Integer> getRow(int rowIndex) {
        //Time O(n^2)
        //Space O(k)
        List<Integer> res = new ArrayList<>();
        int i = 1;
        res.add(1);
        while(i <= rowIndex){
            for(int j = 0; j <= i; j++){
                if(j == 0) continue;
                else if(j == i) res.add(1);
                else{
                    int in = res.get(0) + res.get(1);
                    res.add(in);
                    res.remove(0);
                }
            }
            i++;
        }
        return res;
    }
}
