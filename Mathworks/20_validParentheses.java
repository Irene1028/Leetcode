class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        int len = s.length();
        //int left = 0, right = len - 1;
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        Deque<Character> openStack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                // is open
                openStack.offerFirst(cur);
            } else {
                // is close
                // System.out.println(cur);
                // System.out.println(openStack.peekFirst());
                if (openStack.peekFirst() == null) {
                    return false;
                }
                if (cur == map.get(openStack.peekFirst())) {
                    openStack.pollFirst();
                } else {
                    
                    return false;
                }
            }
        }
        if (openStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
