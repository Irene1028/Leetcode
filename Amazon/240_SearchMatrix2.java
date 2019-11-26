class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. O(m*n), traverse one by one
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 2. O(m*n), traverse one by one but break early
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) return false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    break;
                } 
            }
        }
        return false;
    }
}

// 3. LogN! binary search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 2. use recursion
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int maxLen = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < maxLen; i++) {
            //System.out.println(i);
            boolean rowFound = binarySearch(matrix, target, i, true);
            boolean colFound = binarySearch(matrix, target, i, false);
            if (rowFound || colFound) return true;
        }
        return false;
    }
    private boolean binarySearch(int[][] matrix, int target, int upLeft, boolean searchRow) {
        int start = upLeft;
        int end = searchRow? matrix[0].length - 1: matrix.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            
            if (searchRow) {
                //System.out.print(mid);
                if (matrix[upLeft][mid] == target) return true;
                if (matrix[upLeft][mid] > target) end = mid - 1;
                if (matrix[upLeft][mid] < target) start = mid + 1;
            } else {
                //System.out.println(mid);
                if (matrix[mid][upLeft] == target) return true;
                if (matrix[mid][upLeft] > target) end = mid - 1;
                if (matrix[mid][upLeft] < target) start = mid + 1;
            }
        }
        return false;
    }
}

// 4. devide and conquer

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return devideMatrix(matrix, target, 0, matrix[0].length - 1, 0, matrix.length - 1);
    }
    private boolean devideMatrix(int[][] matrix, int target, int left, int right, int up, int down) {
        // base case
        if (left > right || up > down) return false;
        if (target < matrix[up][left] || target > matrix[down][right]) return false;
        int mid = (left + right) / 2;
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target)
                return true;
            row++;
        }
        return devideMatrix(matrix, target, left, mid - 1, row, down)
            || devideMatrix(matrix, target, mid + 1, right, up, row - 1);
    }
}
