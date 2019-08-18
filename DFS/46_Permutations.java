class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        helper(nums, result, cur);
        return result;
    }
    
    // helper function
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> cur){
        // base case
        if(cur.size() == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        
        // while cur.size() < nums.length
        int i = 0;
        while(i < nums.length){
            if(!cur.contains(nums[i])){
                cur.add(nums[i]);
                helper(nums, result, cur);
                cur.remove(cur.size()-1);
            }
            i++;
        }
    }
}
// so cool
