class Solution {
    public int myAtoi(String str) {
        if (str.equals("")) return 0;
        String num = "";
        int sign = 1;
        boolean valid = false;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c) && c != '-' && c != ' ' && c != '+') {
                return 0;
            }
            if (c == '-' || c == '+') {
                if (i < str.length() - 1 && !Character.isDigit(str.charAt(i+1))) {
                    return 0;
                }
            }
            if (Character.isDigit(c)) {
                if(i > 0 && str.charAt(i-1) == '-') {
                    sign = -1;
                }
                while (Character.isDigit(c)) {
                    num += c;
                    i++;
                    if (i >= str.length()) break;
                    c = str.charAt(i);
                }
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            // System.out.println(digit);
            if (sign == 1) {
                if (res < Integer.MAX_VALUE/10) {
                    res = res * 10 + digit;
                } else if (res == Integer.MAX_VALUE/10 && digit <= Integer.MAX_VALUE%10) {
                    // System.out.println("digit");
                    res = res * 10 + digit;
                } else {
                    res = Integer.MAX_VALUE;
                    break;
                }
            }
            if (sign == -1) {
                if (res > Integer.MIN_VALUE/10) {
                    res = res * 10 - digit;
                } else if (res == Integer.MIN_VALUE/10 && digit * sign >= Integer.MIN_VALUE%10){
                    // System.out.println(res);
                    // System.out.println(digit);
                    res = res * 10 - digit;
                } else {
                    res = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        
        // System.out.println("end");
        return res;
    }
}
