// or you can just add a contains condition before add ans to result
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        helper(0, nums, result);
        return result;
    }
    private void helper(int index, int[] nums, List<List<Integer>> result){
        Set<Integer> swappedNums = new HashSet<>();
        // base case
        if(index == nums.length){
            List<Integer> ans = new ArrayList<>();
            toList(nums, ans);
            //if(!result.contains(ans)){
            //if()
            result.add(new ArrayList<>(ans));
            //}
            return;
        }
        // else
        
        for(int i = index; i < nums.length; i++){
            if(swappedNums.add(nums[i])){
                swap(nums, index, i);
                helper(index + 1, nums, result);
                swap(nums, index, i);
            }
        }
    }
    private void toList(int[] nums, List<Integer> ans){
        for(int i = 0; i < nums.length; i++){
            ans.add(nums[i]);
            //System.out.print(nums[i]);
        }
        //System.out.println("_");
    }
    private void swap(int[] nums, int index, int i){
        // System.out.println(index + "and" + i);
        int tmp = nums[index];
        nums[index] = nums[i];
        nums[i] = tmp;
    }
}

