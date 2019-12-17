class LFUCache {
    // mapping key to value
    Map<Integer, Integer> values; 
    // mapping key to frequence
    Map<Integer, Integer> freqs;
    // mapping freq to keys of the same count
    Map<Integer, LinkedHashSet<Integer>> times2keys;
    // minimum frequency
    int minFreq;
    int cap;
    public LFUCache(int capacity) {
        values = new HashMap<>();
        freqs = new HashMap<>();
        times2keys = new HashMap<>();
        minFreq = 0;
        cap = capacity;
    }
    
    public int get(int key) {
        if (values.containsKey(key)) {
            int count = freqs.get(key);
            update(key, count, count + 1);
            return values.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // if cache is full
        if (cap <= 0) {
            return;
        }
        // 
        if (values.containsKey(key)) {
            values.put(key, value);
            // System.out.println("put - cache contains key");
            int count = freqs.get(key);
            // System.out.println(count);
            update(key, count, count + 1);
        } else {
            if (values.size() >= cap) {
                // System.out.println("put - cache is full");
                // System.out.println(minFreq);
                int toBeRemoved = times2keys.get(minFreq).iterator().next(); // key
                values.remove(toBeRemoved);
                freqs.put(toBeRemoved, 0);
                times2keys.get(minFreq).remove(toBeRemoved);
                if (freqs.get(toBeRemoved) == minFreq && times2keys.get(minFreq).size() == 0) {
                    minFreq++;
                }
            }
            values.put(key, value);
            // System.out.println("put - cache doesnt contain key");
            update(key, 0, 1);
        }
        return;
    }
    
    public void update(int key, int count, int newCount) {
        freqs.put(key, newCount);
        if (!times2keys.containsKey(newCount)) {
            // if new count does not exist, new a list
            times2keys.put(newCount, new LinkedHashSet<>());
        } 
        // add key into new list, remove old record   
        times2keys.get(newCount).add(key);
        if (times2keys.containsKey(count)) {
            times2keys.get(count).remove(key);
        }
        if (count == 0) minFreq = newCount;
        if (minFreq == 0 || count == minFreq && times2keys.get(minFreq).size() == 0) {
            minFreq++;
        }
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
