// use stack
// Time O(n1 + n2)
// Space O(n2)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // simplest idea
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0 || n2 == 0) return new int[0];
        int[] ret = new int[n1];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        stack.push(nums2[0]);
        for (int i = 1; i < n2; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < n1; i++) {
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }
}

// Time O(n2 * n1) in the worst case
// Space O(n2);
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // simplest idea
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ret = new int[n1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < n1; i++) {
            int start = map.get(nums1[i]);
            while (start < n2) {
                if (nums2[start] > nums1[i]) {
                    ret[i] = nums2[start];
                    break;
                }
                start++;
            }
            if (start >= n2)
                ret[i] = -1;
        }
        return ret;
    }
}
