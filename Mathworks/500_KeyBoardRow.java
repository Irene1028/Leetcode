class Solution {
    public String[] findWords(String[] words) {
        if (words.length == 0) return words;
        char[] row1 = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        char[] row2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] row3 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        Map<Character, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (char c : row1) {
            map.put(c, 1);
        }
        for (char c : row2) {
            map.put(c, 2);
        }
        for (char c : row3) {
            map.put(c, 3);
        }
        for (String s : words) {
            String sLow = s.toLowerCase();
            int curRow = map.get(sLow.charAt(0));
            int i = 0;
            for (i = 1; i < s.length(); i++) {
                if (map.get(sLow.charAt(i)) != curRow) {
                    break;
                }
            }
            if (i == s.length()) {
                ans.add(s);
            }
        }
        String[] ret = new String[ans.size()];
        for (int j = 0; j < ans.size(); j++) {
            ret[j] = ans.get(j);
        }
        return ret;
    }
}

// 1. toLowerCase and toUpperCase could only be used on string
// 2. cornor case string is "", string[] is empty
// 3. toArray function
class Solution {
    public String[] findWords(String[] words) {
        if (words.length == 0) return new String[0];
        Map<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        String[] rows = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        for (int i = 0; i < 3; i++) {
            for (char c : rows[i].toCharArray()) {
                map.put(c, i);
            }
        }
        for (String s : words) {
            if (s.equals("")) {
                res.add(s);
                continue;
            }
            int itsRow = map.get(s.toUpperCase().charAt(0));
            for (char c : s.toUpperCase().toCharArray()) {
                if (map.get(c) != itsRow) {
                    itsRow = -1;
                    break;
                }
            }
            if (itsRow != -1) {
                res.add(s);
            }
        }
        return res.toArray(new String[0]);
    }
}
