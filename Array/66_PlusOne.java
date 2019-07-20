class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int tmp = digits[len-1] + 1;
        for(int i = len-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // if it did not return in the loop
        // the only condition is like 999 + 1 = 1000
        int[] ans = new int[len+1];
        ans[0] = 1;
        return ans;
    }
}
