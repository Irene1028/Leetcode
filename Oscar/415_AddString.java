class Solution {
    public String addStrings(String num1, String num2) {
        //int len1 = num1.length(), len2 = num2.length();
        String longStr =  num1.length() < num2.length() ? num2 : num1;
        String shortStr = num1.length() < num2.length() ? num1 : num2;
        int carry = 0;
        int i = longStr.length() - 1;
        int j = shortStr.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0){
            int n1 = longStr.charAt(i) - '0';
            int n2 = j >= 0 ? shortStr.charAt(j) - '0': 0;
            int cur = (n1 + n2 + carry) % 10;
            sb.append(Character.forDigit(cur, 10));
            carry = (n1 + n2 + carry) / 10;
            i--;
            j--;
        }
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }
}
