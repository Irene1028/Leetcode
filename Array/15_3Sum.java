// my solution.
// Brute Force, time limit exceeded.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> one_slt = new ArrayList<Integer>();
                        one_slt.add(nums[i]);
                        one_slt.add(nums[j]);
                        one_slt.add(nums[k]);
                        if(!ans.contains(one_slt)){
                            ans.add(one_slt);
                        }
                        else{
                            continue;
                        }
                    }
                }
            } 
        }
        
        return ans;
        
    }
}

// my accepted solution.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        // base case, nums.length < 3
        if(nums.length < 3) return ans;
        
        for(int i = 0; i<nums.length-2; i++){
            if(nums[i]>0) return ans;
            if(i == 0 || nums[i] != nums[i-1]){
                int lo = i+1, hi = nums.length-1;
                while(lo < hi){
                    if(nums[i] + nums[lo] + nums[hi] == 0){
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    }
                    else if(nums[i] + nums[lo] + nums[hi] < 0){
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                    }
                    else{
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        hi--;
                    }
                }
            }
        }
        return ans;
        
    }
}
