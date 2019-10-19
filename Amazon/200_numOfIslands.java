class Solution {
    public int numIslands(char[][] grid) {
        // first idea
        // traverse everyone and see if neighbors around is 1
        if (grid.length == 0) return 0;
        int width = grid[0].length;
        int height = grid.length;
        int numOfIslands = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    helperDfs(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }
    
    public void helperDfs (char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        } else {
            return;
        }
        helperDfs(grid, x+1, y);
        helperDfs(grid, x-1, y);
        helperDfs(grid, x, y+1);
        helperDfs(grid, x, y-1);
    }
}
