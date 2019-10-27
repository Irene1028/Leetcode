class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int zero = 0;
        int nonZero = 0;
        while(nonZero < nums.length) {
            while (zero < nums.length && nums[zero] != 0) {
                zero++;
            }
            while (nonZero < nums.length && nums[nonZero] == 0) {
                nonZero++;
            }
            if (zero == nums.length || nonZero == nums.length) {
                return;
            }
            int tmp = nums[zero];
            nums[zero] = nums[nonZero];
            nums[nonZero] = tmp;
        }
        return;
    }
}
