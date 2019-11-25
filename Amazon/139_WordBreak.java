/*
dp solution
time is n^2
space is n
*/
class Solution {
    //Map<String, Boolean> map;
    Set<String> set;
    boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        // brute force
        set = new HashSet<>();
        for (String str: wordDict) {
            set.add(str);
        }
        // map = new HashMap<>();
        dp = new boolean[s.length() + 1];
        // the string before index is breakable
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // System.out.println(s.substring(j, i));
                if (dp[j] && set.contains(s.substring(j, i))) {
                    // System.out.print(i);
                    // System.out.println(" is true.");
                    dp[i] = true;
                    break;
                }
            }
            // System.out.print(i);
            // System.out.println(" is false.");
            // dp[i] = false;
        }
        return dp[s.length()];
    }
    
}
