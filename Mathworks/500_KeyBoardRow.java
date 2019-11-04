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
