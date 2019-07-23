//
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for(i = 0, j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }
}
