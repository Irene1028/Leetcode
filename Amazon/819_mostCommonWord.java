class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph.length() == 0) {
            return "";
        }
        Map<String, Integer> map = new TreeMap<>();
        Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>> () {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        };
        Set<String> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        String str = paragraph.toLowerCase();
        String[] arrOfStr = str.replaceAll("[^a-zA-Z ]", " ").split("\\s+");
        for (int i = 0; i < arrOfStr.length; i++) {
            // System.out.println(i);
            // System.out.println(arrOfStr[i]);
            if (!set.contains(arrOfStr[i])) {
                if (map.containsKey(arrOfStr[i])) {
                    map.put(arrOfStr[i], map.get(arrOfStr[i]) + 1);
                } else {
                    map.put(arrOfStr[i], 1);
                }
            }
                
        }
        //这里将map.entrySet()转换成list
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, cmp);
        // Map.Entry<String, Integer> en = map.firstEntry();
        return list.get(0).getKey();
    }
}


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph.length() == 0) {
            return "";
        }
        Map<String, Integer> map = new TreeMap<>();
        Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>> () {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        };
        Set<String> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        String s = "";
        int freq = 0;
        String str = paragraph.toLowerCase();
        String[] arrOfStr = str.replaceAll("[^a-zA-Z ]", " ").split("\\s+");
        for (int i = 0; i < arrOfStr.length; i++) {
            // System.out.println(i);
            // System.out.println(arrOfStr[i]);
            if (!set.contains(arrOfStr[i])) {
                if (map.containsKey(arrOfStr[i])) {
                    map.put(arrOfStr[i], map.get(arrOfStr[i]) + 1);
                } else {
                    map.put(arrOfStr[i], 1);
                }
                if (map.get(arrOfStr[i]) > freq) {
                    s = arrOfStr[i];
                    freq = map.get(arrOfStr[i]);
                }
            }
                
        }
        
        return s;
    }
}
