class Solution {
    Map<String, String> mapping = new HashMap<>();
    List<String> ans = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        mapping.put("2", "abc");
        mapping.put("3", "def");
        mapping.put("4", "ghi");
        mapping.put("5", "jkl");
        mapping.put("6", "mno");
        mapping.put("7", "pqrs");
        mapping.put("8", "tuv");
        mapping.put("9", "wxyz");
        helper("", digits);
        return ans;
    }
    
    private void helper(String cur, String restDigits){
        if (restDigits.length() == 0) {
            ans.add(cur);
            return;
        }
        String options = mapping.get(restDigits.substring(0, 1));
        for (int i = 0; i < options.length(); i++) {
            String letter = options.substring(i, i + 1);
            helper(cur + letter, restDigits.substring(1));
        }
    }
}
