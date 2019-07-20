/* version 1.0 */
// initialize sum and max to nums[0]
// sum represents the bigest sum of subarray ending on nums[i-1]
// max represents the maximum so far
// begin from nums[0] and scan to the end
// keep track of sum and max
class Solution {
    public int maxSubArray(int[] nums) {
        // base case nums.length == 0
        if(nums.length == 0) return 0;
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length; i++){
            // if sum is smaller than 0, it will decrease nums[i], so update sum with nums[i]
            // if sum is bigger than or equal to 0, it will not hurt to add sum to nums[i]
            if(sum < 0) sum = nums[i];
            else sum = sum + nums[i];
            // after updating sum, check whether this sum is bigger than max we found so far
            if(sum > max) max = sum;
        }
        return max;
    }
}

/* version 2.0 */
