class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return -1;
        }
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = q.poll();
        }
        return ans;
    }
}

// Time
// The time complexity of adding an element in a heap of size k is O(logk), and we do it N times that means O(Nlogk) time complexity for the algorithm.
// Space, O(n)
