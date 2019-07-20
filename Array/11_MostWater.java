// my solution
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = 1, max = 0;
        for(i = 0; i < height.length-1; i++){
            for(j = i+1; j < height.length; j++){
                int h = Math.min(height[i], height[j]);
                if(h * (j-i) > max) max = h*(j-i);
            }
        }
        return max;
    }
}

// a nice solution from fabrizio3, thoughts are copied from his answer.

//Start with pointer left=0 and pointer right=length-1
//The max water is limited by the pointer with smaller height
//When moving a pointer, the width of the area decrease
//If we move the pointer with higher height, we will never get a
//greater area, the max height will be at most the one of the pointer with smaller height.
//So we need to move the pointer with smaller height to have a chance to get higher height at the next step.

 public int maxArea(int[] height) {
		int maxWater = 0, left = 0, right = height.length-1;
		while(left < right) {
			maxWater = Math.max(maxWater, (right-left) * Math.min(height[left], height[right]));
			if(height[left] < height[right]) left++;
			else right--;
		}
		return maxWater;
	}
  
