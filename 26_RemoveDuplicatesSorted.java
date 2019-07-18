class Solution {
    public int removeDuplicates(int[] nums) {
        // base case nums.length == 0 or 1
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int i = 0, j = 1;
        while(j<nums.length){
            if(nums[i] != nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
            j++;
        }
        return i+1; 
    }
}
