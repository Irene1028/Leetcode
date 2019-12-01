// dfs
class Solution {
    char[][] mygrid;
    public int numIslands(char[][] grid) {
        // brute force
        if (grid.length == 0 || grid[0].length == 0) return 0;
        mygrid = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //check whether new island
                if (mygrid[i][j] == '1') {
                    count++;
                    removeOnes(i, j);
                }
                
            }
        }
        return count;
    }
    private void removeOnes(int i, int j) {
        if (i < 0 || j < 0 || i >= mygrid.length || j >= mygrid[0].length || mygrid[i][j] == '0') return;
        mygrid[i][j] = '0';
        removeOnes(i-1, j);
        removeOnes(i+1, j);
        removeOnes(i, j-1);
        removeOnes(i, j+1);
    }
}
// Time O(M * N), for loop iterates M * N times
// Space O(M * N), use mygrid

// bfs slow
import javafx.util.Pair;

class Solution {
    // BFS
    public int numIslands(char[][] grid) {
        // brute force
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // bfs start!
                    count++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * grid[0].length + j);
                    while (!queue.isEmpty()) {
                        int code = queue.poll();
                        int x = code / grid[0].length;
                        int y = code % grid[0].length;
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.offer((x - 1)*grid[0].length + y);
                            grid[x - 1][y] = '0';
                        }
                        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                            queue.offer((x + 1)*grid[0].length + y);
                            grid[x + 1][y] = '0';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.offer(x * grid[0].length + y - 1);
                            grid[x][y - 1] = '0';
                        }
                        if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                            queue.offer(x * grid[0].length + y + 1);
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}
