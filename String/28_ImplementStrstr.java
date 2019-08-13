/* My wrong solution */
/*
 This solution cannot detect needle correctly
 The problem is after find first a few same chars in haystack but meet a unexpected char, 
 it will ignore passed chars and find from the next char after the unexpected char.
 This means if we are looking for "2322" in "2323223",
 we will first detect 232 in the head of the string. 
 But when we find it is just 232, not 2322, we will move to look the rest chars "3223",
 which means we will miss the 2322 indexed from 2 to 5.
 A good solution is posted below.
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 && haystack.length()==0) return 0;
        if(haystack.length()==0) return -1;
        int hPointer=0, nPointer=0;
        while(hPointer<haystack.length() && nPointer<needle.length()){
            if(haystack.charAt(hPointer) == needle.charAt(nPointer)){
                hPointer++;
                nPointer++;
            }
            else{
                hPointer++;
                nPointer = 0;
            }
        }
        if(nPointer == needle.length()) return hPointer-needle.length();
        else return -1;
        
    }
}

/*
This is a solution which will work but exceed time limited
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 && haystack.length()==0) return 0;
        if(haystack.length()==0) return -1;
        int hPointer=0;
        while(hPointer<haystack.length()-needle.length()){
            if(haystack.charAt(hPointer) == needle.charAt(0)){
                String str = haystack.substring(hPointer, hPointer+needle.length());
                if(needle.compareTo(str) == 0) return hPointer;
            }
            else{
                hPointer++;
            }
        }
        return -1;
    }
}

/*
An accepted solution
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int l2 = needle.length(), l1 = haystack.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int hPointer = 0, nPointer = 0;
        while(hPointer <= l1-l2){
            if(haystack.charAt(hPointer) == needle.charAt(0)){
                while(nPointer < l2){
                    if(haystack.charAt(hPointer+nPointer) != needle.charAt(nPointer)){
                        break;
                    }
                    nPointer++;
                }
                if(nPointer == l2) return hPointer;
            }
            nPointer = 0;
            hPointer++;
        }
        return -1;
    }
}
