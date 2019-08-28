class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        // brute force
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                if(nums[i+1] < nums[i]) return i;
            }
            else if(i == nums.length-1){
                if(nums[i-1] < nums[i]) return i;
            }
            else{
                if(nums[i-1] < nums[i] && nums[i+1] < nums[i]) return i;
            }
        }
        return 0;
    }
    
}
