class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int len = matrix[0].length, height = matrix.length;
        int max = 0;
        // if (len == 1 || height == 1) {
        //     max = 1;
        // }
        int[][] dp = new int[height][len];
        //int max = Integer.MIN_VALUE;
        // fill the last column
        for (int i = 0; i < height; i++) {
            dp[i][len-1] = Character.getNumericValue(matrix[i][len-1]);
            if (dp[i][len-1] > max) {
                max = dp[i][len-1];
            }
            //System.out.println("fill column" + dp[i][len-1]);
        }
        // fill the last row
        for (int j = 0; j < len - 1; j++) {
            dp[height-1][j] = Character.getNumericValue(matrix[height-1][j]);
            if (dp[height-1][j] > max) {
                max = dp[height-1][j];
            }
            //System.out.println("fill column" + dp[height-1][j]);
        }
        // fill the rest of dp table
        for (int i = height - 2; i >= 0; i--) {
            for (int j = len - 2; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i][j+1])) + 1;
                }
                //System.out.println(dp[i][j]);
                // update max square len
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    //System.out.println(max);
                }
            }
        }
        return max * max;
    }
}
