public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> solution = new ArrayList<>();
        Arrays.sort(people,(a,b)->a[0]!=b[0]?-a[0]+b[0]:a[1]-b[1]);
        for(int[] i:people){
            solution.add(i[1],i);
        }
        return solution.toArray(new int[solution.size()][]);
    }
}