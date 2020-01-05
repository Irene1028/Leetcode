class Solution {
    int[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return match(0, 0, s, removeDup(p));
    }
    public boolean match(int i, int j, String s, String p) {
        if (i == s.length() && j == p.length()) return true;
        if (i == s.length()) {
            if (j == p.length() - 1 && p.charAt(j) == '*') return true;
            return false;
        }
        if (j == p.length()) {
            if (j > 0 && p.charAt(j - 1) == '*') return true;
            return false;
        }
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1? true: false;
        }
        boolean ans = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            if (match(i + 1, j + 1, s, p))
                ans = true;
        } else {
            // p != s
            if (p.charAt(j) == '*') {
                if (match(i + 1, j, s, p) || match(i, j + 1, s, p)) {
                    ans = true;
                }
            }
        }
        memo[i][j] = ans? 1: 0;
        return ans;
    }
    public String removeDup(String p) {
        if (p.equals("")) return p;
        StringBuilder res = new StringBuilder();
        res.append(p.charAt(0));
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i - 1) == '*' && p.charAt(i) =='*') {
                continue;
            }
            res.append(p.charAt(i));
        }
        System.out.println(res.toString());
        return res.toString();
    }
}
