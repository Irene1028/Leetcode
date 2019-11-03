class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int length = obstacleGrid[0].length;
        int[][] dp = new int[height][length];
        // dp[0][0] = 0;
        // dp[0][1] = 1;
        // dp[1][0] = 1;
       
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0){
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[height-1][length-1];
    }
}
