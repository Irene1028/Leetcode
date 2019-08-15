class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int head = 0, tail = len - 1;
        char tmp;
        while(head < tail){
            tmp = s[head];
            s[head] = s[tail];
            s[tail] = tmp;
            head++;
            tail--;
        }
    }
}
