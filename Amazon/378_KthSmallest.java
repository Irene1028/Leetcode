class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0 && q.size() >= k && matrix[i][j] > q.peek()) {
                    break;                    
                }
                q.offer(matrix[i][j]);
                if (q.size() > k) { // must be less than
                    q.poll();
                }
            }
        }
        return q.poll();
    }
}
