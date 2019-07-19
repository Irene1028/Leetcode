class Solution {
    public int removeElement(int[] nums, int val) {
        // base case nums.length == 0;
        if (nums.length == 0) return 0;
        // base case nums.length == 1, nums[0]==val
        if (nums.length == 1 && nums[0] == val) return 0;
        // base case nums.length == 1, nums[0]!=val
        if (nums.length == 1 && nums[0] != val) return 1;
        
        // sort nums
        // nums = sort(nums);
        int i = 0, j = 0;
        
        while(j<nums.length){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
        
    }
}
