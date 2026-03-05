import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If opening bracket, push its matching closing bracket
            if (ch == '(') {
                stack.push(')');
            } 
            else if (ch == '{') {
                stack.push('}');
            } 
            else if (ch == '[') {
                stack.push(']');
            } 
            else {
                // If closing bracket, check stack
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}