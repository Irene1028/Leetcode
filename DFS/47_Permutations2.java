class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map cur = new LinkedHashMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        helper(nums, result, cur);
        return result;
    }
    private void helper(int[] nums, List<List<Integer>> result, Map cur){
        // base case
        if(cur.size() == nums.length){
            List<Integer> ans = new ArrayList<>();
            int i = 0;
            for(Object key : cur.keySet().toArray()){
                int num = Integer.parseInt(cur.get(key).toString());
                ans.add(num);
                //System.out.print(num);
            }
        
            if(!result.contains(ans)){
                result.add(ans);
            }
            //System.out.println("_");
            return;
        }
        // while ans.size() < nums.length
        int index = 0;
        while(index < nums.length){
            if(!cur.containsKey(index)){
                cur.put(index, nums[index]);
                //System.out.println("add" + nums[index]);
                helper(nums, result, cur);
                cur.remove(index);
                //System.out.println("remove" + nums[index]);
            }
            index++;
        }
    }
}
