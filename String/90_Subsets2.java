class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        List<Integer> cur = new ArrayList<>();
        
        helper(nums, 0, result, cur);
        return result;
    }
    
    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> cur){
        // base case
        if(index == nums.length){
            if(!result.contains(cur)){
                // System.out.println(index);
                result.add(new ArrayList<>(cur));
                return;
            }
            return;
        }
        // add
        cur.add(nums[index]);
        helper(nums, index + 1, result, cur);
        cur.remove(cur.size() - 1);
        // not add
        helper(nums, index + 1, result, cur);
    }
}

/*
A faster solution from Guanwen
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // nlogn
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        List<Integer> cur = new ArrayList<>();
        
        helper(nums, 0, result, cur);
        return result;
    }
    
    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> cur){
        // base case
        if(index == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        
        // add
        cur.add(nums[index]);
        helper(nums, index + 1, result, cur);
        cur.remove(cur.size() - 1);
        // skip all same numbers
        while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
            index++;
        }
        // not add
        helper(nums, index + 1, result, cur);
    }
}
// Time = O(2^n)
// Extra space = O(n)
