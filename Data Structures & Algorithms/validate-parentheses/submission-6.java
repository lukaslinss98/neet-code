class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) return false;

                Character poped = stack.pop();
                if ((poped == '(' && c != ')') || (poped == '[' && c != ']') || (poped == '{' && c != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
