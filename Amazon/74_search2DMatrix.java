class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) return true;
            else if (matrix[mid / cols][mid % cols] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}

// binary search
// time is O(log(mn))
// Space is constant
