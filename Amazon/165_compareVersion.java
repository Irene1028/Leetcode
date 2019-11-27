class Solution {
    public int compareVersion(String version1, String version2) {
        // 1. transform string to int[] and get int value of two nums.
        // string.split
        // System.out.println(version1);
        // System.out.println(version2);
         
        String[] chars1 = version1.split("\\.", -2); // escape!!!!
        String[] chars2 = version2.split("\\.", -2);
        int len1 = chars1.length;
        int len2 = chars2.length;
        int len = Math.max(len1, len2);
        int[] num1 = new int[len];
        int[] num2 = new int[len];
        for (int i = 0; i < len1; i++) {
            num1[i] = Integer.valueOf(chars1[i]);
        }
        for (int i = 0; i < len2; i++) {
            num2[i] = Integer.valueOf(chars2[i]);
        }
        for (int i = 0; i < len; i++) {
            if (num1[i] > num2[i]) return 1;
            else if (num1[i] < num2[i]) return -1;
        }
        return 0;
    }
}
