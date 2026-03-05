class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int open = 0;

        // First pass: remove invalid ')'
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open == 0) {
                    sb.deleteCharAt(i);
                    i--; // adjust index after deletion
                } else {
                    open--;
                }
            }
        }

        // Second pass: remove extra '(' from right side
        for (int i = sb.length() - 1; i >= 0 && open > 0; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                open--;
            }
        }

        return sb.toString();
    }
}