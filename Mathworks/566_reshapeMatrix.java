class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length == 0) return nums;
        if (r * c != nums.length * nums[0].length) return nums;
        int[][] newArray = new int[r][c];
        for (int i = 0; i <= r * c - 1; i++) {
            newArray[i / c][i % c] = nums[i / nums[0].length][i % nums[0].length];
        }
        return newArray;
        
    }
}

// time is O(mn)
// space is const
// result array is O(mn)
