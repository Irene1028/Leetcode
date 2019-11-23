class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //if (n == 1) return;
        int tmp = 0;
        int k = 3;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // System.out.println(i);
                // System.out.println(j);
                int curX = j;
                int curY = n - i - 1;
                while (k != 0) {
                    // System.out.println(matrix[curX][curY]);
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[curX][curY];
                    matrix[curX][curY] = tmp;
                    int curXTmp = curX; 
                    curX = curY;
                    curY = n - curXTmp - 1;
                    k--;
                }
                k = 3;
            }
        }
    }
    
}
