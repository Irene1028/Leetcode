class Solution {
    public String lastSubstring(String s) {
        int i = 0, j = 1, offset = 0, len = s.length();
        while (i + offset < len && j + offset < len) {
            char c1 = s.charAt(i + offset);
            char c2 = s.charAt(j + offset);
            if (c1 == c2) {
                // prefix is the same, look at the next one;
                offset++;
            } else {
                if (c1 > c2) {
                    // System.out.println(c1);
                    // System.out.println(c2);
                    // c1 must be lower than c2
                    // keep c1 and move j to find substring lower than c1
                    j += 1;
                    if (i == j) j++;
                }
                if (c2 > c1) {
                    // System.out.println(c1);
                    // System.out.println(c2);
                    i += 1;
                    if (i==j) i++;
                }
                
                offset = 0;
            }
        }
        return s.substring(Math.min(i, j));
    }
}
