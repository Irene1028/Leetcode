class Solution {
    public boolean isPalindrome(String s) {
        // empty string
        if(s.isEmpty()) return true;
        // one char
        if(s.length() == 1) return true;
        // other
        int left = 0, right = s.length()-1;
        char leftChar, rightChar;
        while(left <= right){
            leftChar = s.charAt(left);
            rightChar = s.charAt(right);
            if(!Character.isLetterOrDigit(leftChar)) left++;
            else if(!Character.isLetterOrDigit(rightChar)) right--;
            else{
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    // System.out.println(leftChar);
                    // System.out.println(rightChar);
                    return false;
                }
                else{
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}
