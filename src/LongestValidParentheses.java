import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 * ---
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int ret = 0;
        final Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                }

                int x = i - stack.peek();
                ret = Math.max(x, ret);
            }
        }

        return ret;
    }
}
