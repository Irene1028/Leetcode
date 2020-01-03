class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            char c1 = i < 0? '0': a.charAt(i);
            char c2 = j < 0? '0': b.charAt(j);
            if (c1 != c2) {
                // 1 + 0, 0 + 1
                if (carry == 0) {
                    sb.append('1');
                    carry = 0;
                } else {
                    sb.append('0');
                    carry = 1;
                }  
            } else {
                // 0 + 0
                if (c1 == '0') {
                    if (carry == 1) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    } 
                    carry = 0;
                } else {
                    // 1 + 1
                    // System.out.println(i);
                    if (carry == 0) {
                        sb.append('0');
                    } else {
                        sb.append('1');
                    }
                    carry = 1;
                }
            }
            i--;
            j--;
        }
        if (carry == 1) sb.append('1');
        
        return sb.reverse().toString();
    }
}
