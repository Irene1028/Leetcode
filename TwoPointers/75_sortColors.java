class Solution {
    public void sortColors(int[] nums) {
        // two pointers
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int i = 0, j = nums.length-1;
        for(int color = 0; color < nums.length; color++){
            while(i < j){
                // base case
                if(nums[i] != color && nums[j] == color){
                    // System.out.println(i+"and"+j);
                    swap(nums, i, j);
                    // i++;
                    // j--;
                }
                while(nums[i] == color && i<j){
                    i++;
                }
                while(nums[j] != color && j>i){
                    j--;
                }
            }
            j = nums.length - 1;
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        // for(int n = 0; n < nums.length; n++){
        //     System.out.print(nums[n]);
        // }
        // System.out.println("_");
    }
}
