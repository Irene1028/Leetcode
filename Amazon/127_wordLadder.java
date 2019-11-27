import javafx.util.Pair;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // have a hashmap to store the root and words could be formed by the root in wordlist
        int wordLen = beginWord.length();
        Map<String, List<String>> rootToWord = new HashMap<>();
        for (String s : wordList) {
            for (int i = 0; i < wordLen; i++) {
                String curRoot = s.substring(0, i) + '*' + s.substring(i + 1);
                if (rootToWord.containsKey(curRoot)) {
                    // System.out.println("contains");
                    // System.out.println(curRoot);
                    List<String> trans = rootToWord.get(curRoot);
                    trans.add(s);
                    rootToWord.put(curRoot, trans);
                } else {
                    // System.out.println("!contains");
                    // System.out.println(curRoot);
                    List<String> trans = new ArrayList<>();
                    trans.add(s);
                    rootToWord.put(curRoot, trans);
                }
            }
        }
        // have a Queue for BFS
        Queue<Pair<String, Integer>> dict = new LinkedList<Pair<String, Integer>>();
        dict.offer(new Pair(beginWord, 1));
        
        // visited hash map
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!dict.isEmpty()) {
            Pair<String, Integer> curPair = dict.poll();
            String s = curPair.getKey();
            int step = curPair.getValue();
            if (s.equals(endWord)) {
                return step;
            }
            for (int i = 0; i < wordLen; i++) {
                String curRoot = s.substring(0, i) + "*" + s.substring(i+1);
                // System.out.println(curRoot);
                
                // System.out.println(list);
                for (String word : rootToWord.getOrDefault(curRoot, new ArrayList<>())) {
                    if (!visited.containsKey(word)) {
                        visited.put(word, true);
                        dict.offer(new Pair(word, step + 1));
                    }  
                }
            }
        }
        return 0;
    }  
}

// so....difficult...
