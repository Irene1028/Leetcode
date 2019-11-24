class Solution {
    boolean[][] seen;
    int[][] mygrid;
    public int maxAreaOfIsland(int[][] grid) {
        mygrid = grid;
        seen  = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, helper(i, j));
            }
        }
        return max;
    }
    private int helper(int i, int j) {
        if (i < 0 || j < 0 || i >= mygrid.length || j >= mygrid[0].length) return 0;
        if (mygrid[i][j] == 0 || seen[i][j] == true) return 0;
        
        // grid[i][j] == 1
        seen[i][j] = true;
        return 1 + helper(i - 1, j) + helper(i, j - 1) + helper(i, j + 1) + helper(i + 1, j);
    }
}
