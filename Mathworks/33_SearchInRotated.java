// binary search

class Solution {
    public int search(int[] nums, int target) {
        // binary search
        int start = 0, end = nums.length - 1, mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[start]) {
                // left half increasing order
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //right half increasing order
                if (nums[end] >= target && nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }    
        }
        return -1;
        
    }
}
