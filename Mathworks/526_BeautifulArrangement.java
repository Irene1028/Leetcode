class Solution {
    public int countArrangement(int N) {
        boolean[] used = new boolean[N];
        int[] count = new int[1];
        helper(1, used, N, count);
        return count[0];
    }
    public void helper(int pos, boolean[] used, int N, int[] count) {
        // for each position, traverse unused nums
        if (pos > N) {
            count[0]++;
            // System.out.print("count is ");
            // System.out.println(count[0]);
            return;
        }
        // System.out.print("current pos");
        // System.out.println(pos);
        
        for (int i = 0; i < N; i++) {
            if (used[i] == false && ((i + 1) % pos == 0 || pos % (i + 1) == 0)) {
                // if satisfy one of two conditions.
                used[i] = true;
                helper(pos + 1, used, N, count);
                used[i] = false;
            }
        }
        return;
    }
}
