class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int count = 1;
        int i = 0, j = 0;
        for(i = 0, j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                if (count < 2) {
                    nums[++i] = nums[j];
                    count++;
                }
            } else {  
                nums[++i] = nums[j];
                count = 1;
            }
        }
        return i+1;
    }
}
