class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> invalid = new HashSet<>();
        invalid.add("");
        invalid.add(".");
        invalid.add("..");
        // stack.push("");
        for (String s: path.split("/")) {
            if (invalid.contains(s) && !stack.isEmpty()) {
                stack.pop();
            }
            else if (!invalid.contains(s)){
                stack.push(s);
            }
        }
        String res = "";
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            System.out.println("This is " + cur + ".");
            res = "/" + cur + res;
        }
        return res;
    }
}
