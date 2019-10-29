class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int n : nums1) {
            list1.add(n);
        }
        for (int n : nums2) {
            list2.add(n);
        }
        if (list1.size() < list2.size()) {
            return helper(list1, list2);
        }
        return helper(list2, list1);
    }
    public int[] helper(List<Integer> listShort, List<Integer> listLong) {
        int[] ans = new int[listShort.size()];
        int i = 0;
        for (Integer n : listShort) {
            if (listLong.contains(n)) {
                listLong.remove(n);
                ans[i++] = n;
            }
        }
        return Arrays.copyOf(ans, i);
    }
}
