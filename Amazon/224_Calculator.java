class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        
        int base = 0;
        int sign = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(base);
                stack.push(sign);
                base = 0;
                sign = 1;
            } else if (Character.isDigit(s.charAt(i))) {
                int curNum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    curNum = curNum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                base += curNum * sign; 
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == ')') {
                base = base * stack.pop() + stack.pop();
                //System.out.println(base);
            }
        } 
        return base;
    }
    
}
