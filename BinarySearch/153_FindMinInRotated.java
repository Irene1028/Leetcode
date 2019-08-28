class Solution {
    public int findMin(int[] nums) {
        //if(nums.length == 1) return nums[0];
        //if( nums == null || nums.length == 0) return 0;
        // no rotation and len = 0
        if(nums[0] <= nums[nums.length - 1]) return nums[0];
        
        if(nums[0] > nums[nums.length - 1]){
            int i = 0;
            while(i < nums.length){
                if(nums[i] > nums[i+1])
                    return nums[i+1];
                i++;
            }
        }
        return 0;
    }
}
