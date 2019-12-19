class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        Map<Character, Set<Character>> edges = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (Character c: words[i].toCharArray()) {
                // System.out.println(c);
                indegree.put(c, 0);
            }
        }
        for (int i = 0; i + 1 < words.length; i++) {
            int diff = firstDiff(words[i], words[i+1]);
            if (diff != -1) {
                char start = words[i].charAt(diff);
                char end = words[i+1].charAt(diff);
                Set<Character> set = edges.getOrDefault(start, new HashSet<>());
                if (!set.contains(end)) {
                    set.add(end);
                    edges.put(start, set);
                    indegree.put(end, indegree.get(end) + 1);
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (Character k: indegree.keySet()) {
            // System.out.println(k);
            if (indegree.get(k) == 0) {
                q.offer(k);
            }
        }
        int count = 0;
        String res = "";
        while (!q.isEmpty()) {
            Character cur = q.poll();
            // System.out.println(cur);
            res = res + cur;
            count++;
            if (edges.containsKey(cur)) {
                for (Character s : edges.get(cur)) {
                    indegree.put(s, indegree.get(s) - 1);
                    if (indegree.get(s) == 0) {
                        q.offer(s);
                    }
                }
            }
        }
        if (count == indegree.size()) {
            // System.out.println(res);
            return res;
        }
        return "";
    }
    public int firstDiff(String s1, String s2) {
        int i = 0; 
        int len = Math.min(s1.length(), s2.length());
        while (i < len) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }
        if (i == len) return -1;
        return i;
    }
}
