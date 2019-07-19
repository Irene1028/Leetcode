// all negative numbers are not palindrome
// all single digit numbers are not palindrome
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        String s = Integer.toString(x);
        int len = s.length();
        for(int i = 0; i<len/2; i++){
            if(s.charAt(i) != s.charAt(len-i-1))
                return false;
        }
        return true;
    }
}
