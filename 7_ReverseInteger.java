
class Solution {
    public int reverse(int x) {
        
        int rtNumber = 0;
        while (x != 0){
            int lastDigit = x % 10;
            x = x / 10;
            
            /* overflows, return 0 */
            // positive overflow check
            if (rtNumber > Integer.MAX_VALUE/10 || rtNumber == Integer.MAX_VALUE/10 && lastDigit > 7){
                return 0;
            }
            // negative overflow check
            if (rtNumber < Integer.MIN_VALUE/10 || rtNumber == Integer.MIN_VALUE/10 && lastDigit < -8){
                return 0;
            }
            rtNumber = rtNumber * 10 + lastDigit;
        }
        return rtNumber;
    }
}
