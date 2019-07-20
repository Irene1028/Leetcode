// my solution 1. Brute Force.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = 0;
        for(i = 0, j = 1; i < nums.length-1; j++){
            if(nums[i] + nums[j] == target){
                return new int[]{i, j};
            }
            if(j == nums.length - 1){
                i++;
                j = i;
            }
        }
        throw new IllegalArgumentException("No Ans.");
    }
}

// a nice solution, Hash Map: number-->index
// everytime working on nums[i], calculate comp and search map.
// if comp is in the map, return value(index) of key(comp) and current i.
// if comp is not in the map, put (nums[i]-->i) into the map.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[] {map.get(comp), i}; 
            }
            else{
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No Ans.");
    }
}

// my solution 2.
