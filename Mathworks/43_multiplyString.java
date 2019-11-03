class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) 
            return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] ans = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int multiple = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = multiple + ans[i + j + 1];
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        // if (ans[0] != 0) {
        //     sb.append(ans[0]);
        // }
        
        for (int i = 0; i < ans.length; i++) {
            // System.out.println(ans[i]);
            // System.out.println(sb.length());
            if (!(sb.length() == 0 && ans[i] == 0)) {
                //System.out.println("sb.length()");
                sb.append(ans[i]);
            }
        }
        return sb.toString();
    }
}
