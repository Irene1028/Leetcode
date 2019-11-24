class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        Set<String> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String letter = s.substring(j, j + 1);
                if (set.contains(letter)) {
                    if (max < set.size()) {
                        max = set.size();
                    }
                    set.clear();
                    break;
                } else {
                    set.add(letter);
                }
            }
        }
        return max;
    }
}

// Time is too slow, O(n^2)
// Space is O(n)
