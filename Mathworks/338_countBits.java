class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        if (num == 0) return ans;
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + 1;
            }
        }
        return ans;
    }
}

// Time = O(n)
// Space = O(n)
