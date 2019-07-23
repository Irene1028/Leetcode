// my solution 1.
// run time O(n)
// extra space O(n)

class Solution {
    public void rotate(int[] nums, int k) {
        // Brute Force
        int[] ans = new int[nums.length];
        int moveStep = k%nums.length;
        for(int i = 0; i<nums.length; i++){
            ans[(i+k)%nums.length] = nums[i];
        }
        for(int i = 0; i<nums.length; i++){
            nums[i] = ans[i];
        }
        //nums = Arrays.copyOf(ans, nums.length);
    }
}

// my solution 2.
// run time O(n)
// extra space O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        
        for(int curStart = 0; count<nums.length; curStart++){
            int curr = curStart;
            int prev = nums[curStart];
            do{
                int target = (curr + k) % nums.length;
                int tmp = nums[target];
                nums[target] = prev;
                prev = tmp;
                curr = target;
                count++;
            }while(curStart != curr);
        }
    }
}

// my solution 3
// Reversion
