// my solution
// we can also use hash set.
class Solution {
    public int missingNumber(int[] nums) {
        // base case
        if(nums.length==0)
            throw new IllegalArgumentException("length = 0.");
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        int i = 0;
        for(i = 0; i < nums.length; i++){
            if(!map.containsKey(i)) return i;
        }
        return i;
    }
}
