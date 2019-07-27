// HashSet
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.add(i)) set.remove(i);
        }
        return set.iterator().next();
    }
}

//Bit manipulation
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums){
            res ^= i;
        }
        return res;
    }
}
