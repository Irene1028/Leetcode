class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String s = String.valueOf(sorted);
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(s, newList);
            }
        }
        
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
