class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int maxProduct, minProduct;
        int globalMax = max[0];
        for (int i = 1; i < nums.length; i++) {
            maxProduct = nums[i] * max[i-1];
            minProduct = nums[i] * min[i-1];
            max[i] = Math.max(nums[i], Math.max(maxProduct, minProduct));
            min[i] = Math.min(nums[i], Math.min(maxProduct, minProduct));
            if (max[i] > globalMax) {
                globalMax = max[i];
            }
        }
        return globalMax;
    }
}
