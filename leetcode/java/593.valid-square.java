class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return valid(p1, p2, p3, p4) || valid(p1, p3, p2, p4) || valid(p1, p2, p4, p3); 
    }
    
    int computeDis(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]); 
    }
    
    boolean help(int[] p1, int[] p2, int[] p3){
        p1[0]-=p2[0]; 
        p1[1]-=p2[1];
        p2[0]-=p3[0];
        p2[1]-=p3[1];
        return p1[0] * p2[0] + p1[1] * p2[1] == 0;
    }
    
    boolean valid(int[] p1, int[] p2, int[] p3, int[] p4){
        return computeDis(p1, p2) != 0 && computeDis(p1,p2) == computeDis(p2, p3) && computeDis(p2, p3) == computeDis(p3, p4) &&  computeDis(p3, p4) == computeDis(p4, p1) && help(p1,p2,p3);
    }
}