class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int sumOfWater = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = 0;
        //leftMax[1] = height[0];
        rightMax[height.length - 1] = 0;
        //rightMax[height]
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > leftMax[i - 1]) {
                leftMax[i] = height[i - 1];
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] > rightMax[i + 1]) {
                rightMax[i] = height[i + 1];
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < Math.min(leftMax[i], rightMax[i])) {
                sumOfWater += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return sumOfWater;
    }
}
