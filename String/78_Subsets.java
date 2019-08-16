class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        helper(nums, 0, result, cur);
        return result;
    }
    
    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> cur) {
        // case case
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(cur)); // ?
            return;
        }   
        // recursive rule
        // case1: add 
        cur.add(nums[index]);
        helper(nums, index + 1, result, cur);
        cur.remove(cur.size() - 1);
        
        // case2: not add
        helper(nums, index + 1, result, cur);
    }
}
