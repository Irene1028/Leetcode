class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> roomQueue = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // increasing order 
                return a[0] - b[0];
            }
        });
        roomQueue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= roomQueue.peek()) {
                // available
                roomQueue.poll();
                roomQueue.add(intervals[i][1]);
            } else {
                roomQueue.add(intervals[i][1]);
            }
        }
        return roomQueue.size();
    }
}
