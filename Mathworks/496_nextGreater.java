class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // have a map for number -> index;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            while (index < nums2.length) {
                if (nums2[index] > nums1[i]) {
                    list.add(nums2[index]);
                    break;
                }
                index++;
            }
            if (index == nums2.length) {
                list.add(-1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
