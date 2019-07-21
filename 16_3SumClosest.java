// my solution
// this problem is similar to 3Sum.

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int goodSum = 0;
        for(int i = 0; i<nums.length-2; i++){
            int lo = i+1, hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target) return sum;
                else if(sum<target){
                    // sum is smaller than target
                    int diff = target - sum;
                    if(diff < closest){
                        closest = diff;
                        goodSum = sum;
                    }
                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                    lo++;
                }
                else{
                    // sum is bigger than target
                    int diff = sum - target;
                    if(diff < closest){
                        closest = diff;
                        goodSum = sum;
                    }
                    while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                    hi--;
                }
            }
        }
        return goodSum;
    }
}
