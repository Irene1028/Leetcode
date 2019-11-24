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

// O(n) Solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int max = 0;
        for (right = 0; right < s.length(); right++) {
            String letter = s.substring(right, right + 1);
            if (map.containsKey(letter)) {
                left = Math.max(map.get(letter) + 1, left);
            }            
            map.put(letter, right);
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
