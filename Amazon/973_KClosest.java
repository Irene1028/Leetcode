class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // use a tree map, sorted the map with key;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                double d1 = Math.sqrt(a[0]*a[0] + a[1]*a[1]);
                double d2 = Math.sqrt(b[0]*b[0] + b[1]*b[1]);
                return (int) (10 * (d2 - d1));
            }
        });
        
        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }
    
}
