class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                String[] split1 = str1.split(" ", 2);
                String[] split2 = str2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    // both letter
                    if (split1[1].compareTo(split2[1]) != 0) {
                        return split1[1].compareTo(split2[1]);
                        
                    } else {
                        return split1[0].compareTo(split2[0]);
                    }
                }
                if (isDigit1 && isDigit2) {
                    return 0;
                }
                if (isDigit1) {
                    return 1;
                }
                return -1;
            }
        });
        return logs;
    }
}
