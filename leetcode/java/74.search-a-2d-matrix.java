class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n;
        int left = 0;
        int right = len-1;
        int mid = 0;
        while(left<=right){
            mid = (left + right)/2;
            if(matrix[mid/n][mid%n]>target) right = mid-1;
            else if(matrix[mid/n][mid%n]<target) left = mid+1;
            else if(matrix[mid/n][mid%n]==target) return true; 
        }
        return false;
    }
}