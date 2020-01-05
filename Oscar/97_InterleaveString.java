class Solution {
    int[][] memo;
    String str1;
    String str2;
    String str3;
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        str1 = s1;
        str2 = s2;
        str3 = s3;
        return is_Interleave(0, 0, 0);
    }
    public boolean is_Interleave(int i, int j, int k) {
        if (i == str1.length()) return str2.substring(j).equals(str3.substring(k));
        if (j == str2.length()) return str1.substring(i).equals(str3.substring(k));
        if (memo[i][j] >= 0) {
            return memo[i][j] == 0 ? false : true;
        }
        boolean ans = false;
        if (k < str3.length() && str1.charAt(i) == str3.charAt(k)) {
            if (is_Interleave(i+1, j, k+1)) ans = true;
        }
        if (k < str3.length() && str2.charAt(j) == str3.charAt(k)) {
            if (is_Interleave(i, j+1, k+1)) ans = true;
        }
        memo[i][j] = ans? 1: 0;
        return ans;
    }
}
