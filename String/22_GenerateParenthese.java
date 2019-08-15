class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(0, 0, n, result, sb);
        return result;
    }
    
    // left denotes used parenthesis '('
    private void helper(int left, int right, int n, List<String> result, StringBuilder cur) {
        // base case
        if (left == n && right == n) {
            result.add(cur.toString());
            return;
        }
        // recursive rule
        if (left < n) {
            cur.append('(');
            helper(left + 1, right, n, result, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            helper(left, right + 1, n, result, cur);
            cur.deleteCharAt(cur.length() - 1);    
        }
    }
}
