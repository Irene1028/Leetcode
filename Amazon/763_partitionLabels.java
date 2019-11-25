// recurtion

class Solution {
    List<Integer> ans;
    public List<Integer> partitionLabels(String S) {
        ans = new ArrayList<>();
        helper(S);
        return ans;
    }
    private void helper(String s) {
        if (s.length() == 0) return;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i
            int right = s.lastIndexOf(c);
            if (i == 0) len = right;
            if (right > len) len = right;
        }
        ans.add(len + 1);
        helper(s.substring(len + 1));
        return;
    }
}

// iteration
class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S.length() == 0 || S == null) return null;
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int last = 0;
        int[] lastIndexOf = new int[26];
        for(int i = 0; i < S.length(); i++) {
            lastIndexOf[S.charAt(i) - 'a'] = i;
        }
        last = lastIndexOf[S.charAt(0) - 'a'];
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndexOf[S.charAt(i) - 'a']);
            if (last == i) {
                ans.add(last - start + 1);
                start = last + 1;
            }
        }
        return ans;
    }

}
