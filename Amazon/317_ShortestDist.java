class Solution {
    int[][] distance;
    int[][] reach;
    int[] xOffset = {1, -1, 0, 0};
    int[] yOffset = {0, 0, 1, -1};
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        distance = new int[m][n];
        reach = new int[m][n];
        //visited = new boolean[m][n];
        int buildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildings += 1;
                    // if we find a building, we calculate distance and reach num
                    findDistance(grid, i, j);
                } 
            }
        }
        // Time = O(mn)*O(mn) = O(m^2 * n^2)
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j] == buildings) {
                    minDist = Math.min(minDist, distance[i][j]);
                }
            }
        }
        if (minDist == Integer.MAX_VALUE) return -1;
        return minDist;
    }
    
    private void findDistance(int[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.offer(new int[]{row, col});
        int dist = 1;
        // Time = O(mn)
        // Space = O(mn)
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + xOffset[j];
                    int y = cur[1] + yOffset[j];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
                    if (grid[x][y] != 0 || visited[x][y]) continue;
                    distance[x][y] += dist;
                    reach[x][y] += 1;
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
            dist++;
        }
    }
}
