// a nice solution

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;
        while(i>-1 && j>-1){
            nums1[k--] = (nums1[i]>nums2[j])? nums1[i--]: nums2[j--];
        }
        // The second while is what confuses me.
        // Why we consider j>-1, rather than i>-1?
        // When we jumped out from the first loop, there are two conditions:
        // 1. nums2 run out     2. nums1 run out
        // in case 1, we are sure all the nums2 elements were put in appropriate positions.
        // So the left nums1 elements are where they should be, nothing we need to do. Just return.
        // Thus, we only consider consition2. We should copy left numbers to nums1.
        while(j>-1){
            nums1[k--] = nums2[j--];
        }
        return;
    }
}


// updated solution. 09/28/19
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        return;
    }
}
