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
