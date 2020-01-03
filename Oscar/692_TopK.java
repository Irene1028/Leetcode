class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : words) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (freq.get(s2) != freq.get(s1))
                    return freq.get(s2) - freq.get(s1);
                else {
                    return s1.compareTo(s2);
                }
            }
        });
        List<String> res = new ArrayList<>();
        for (String s: freq.keySet()) {
            pq.offer(s);
        }
        while (k > 0 && !pq.isEmpty()) {
            res.add(pq.poll());
            k--;
        }
        return res;
    }
}
