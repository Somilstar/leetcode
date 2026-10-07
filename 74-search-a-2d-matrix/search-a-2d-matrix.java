class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int column = matrix[0].length;

        int left = 0;
        int right = rows*column-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            int row = mid / column;
            int col = mid % column;
            if(matrix[row][col]==target){
                return true;
            }else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return false;
    }
}