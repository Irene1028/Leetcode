// Hash Map solution
// search and insert in hash map has a O(n) complexity
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> myList = new HashMap<Integer, Integer>();
        if(nums.length < 2) return false;
        for(int i = 0; i<nums.length; i++){
            if(myList.containsKey(nums[i])){
                return true;
            }
            else{
                myList.put(nums[i], i);
            }
        }
        return false;
    }
}

// Brute Force solution
// two for loop, O(n^2)

// Sorting solution
// sorting contributes O(nlogn)
// utilizing one sweeping (for loop) to compare neighbors.
