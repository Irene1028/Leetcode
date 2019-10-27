/*
my solution
*/
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // [root, [left-small], [right-big]]
        if (preorder.length == 1 || preorder.length == 0) {
            return true;
        }
        int i = 1;
        while (i < preorder.length && preorder[i] < preorder[0]) {
            i++;
        }
        if (i == preorder.length) {
            int[] left = Arrays.copyOfRange(preorder, 1, i);
            return verifyPreorder(left);
        }
        for (int j = i; j < preorder.length; j++) {
            //System.out.println(preorder[i]);
            if (preorder[j] <= preorder[0]) {  
                return false;
            }
        }
        int[] left = Arrays.copyOfRange(preorder, 1, i);
        int[] right = Arrays.copyOfRange(preorder, i, preorder.length);
        return verifyPreorder(left) && verifyPreorder(right);
        
    }
}

/*
Time O(n^2)
Space O(1)
*/
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length);
    }
    public boolean helper(int[] preorder, int start, int end) {
        if (start == end || start == end - 1) {
            return true;
        }
        int i = start + 1;
        while(i < end && preorder[i] < preorder[start]) {
            i++;
        }
        if (i == end) {
            return helper(preorder, start + 1, end);
        }
        for (int j = i; j < end; j++) {
            if (preorder[j] <= preorder[start]) {
                return false;
            }
        }
        return helper(preorder, start + 1, i) && helper(preorder, i, end);
    }
}
