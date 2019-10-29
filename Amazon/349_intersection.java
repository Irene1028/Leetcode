class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        if (set1.size() < set2.size()) {
            return helper(set1, set2);
        }
        return helper(set2, set1);
    }
    public int[] helper(Set<Integer> setShort, Set<Integer> setLong) {
        int[] ans = new int[setShort.size()];
        int i = 0;
        for (Integer a : setShort) {
            if (setLong.contains(a)) {
                ans[i++] = a;
            }
        }
        return Arrays.copyOf(ans, i);
    }
}

/*
Time = O(m+n), m for nums1 traverse, n for nums2 traverse, contains = O(1), because of HashSet.
Space = O(m+n), m for set1, n for set2, in the worst case when all elements in the arrays are different.
In the worst case, we do not have intersection. So the int array is of length 0.
*/
