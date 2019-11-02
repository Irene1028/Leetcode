class Solution {
    public int numTrees(int n) {
        int[] sortedArr = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArr[i] = i + 1;
        }
        return helper(sortedArr);
    }
    public int helper(int[] arr) {
        if (arr.length == 1 || arr.length == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int validLeft = helper(Arrays.copyOfRange(arr, 0, i));
            int validRight = helper(Arrays.copyOfRange(arr, i+1, arr.length));
             ans += validLeft * validRight;
        }
        return ans;
    }
}
