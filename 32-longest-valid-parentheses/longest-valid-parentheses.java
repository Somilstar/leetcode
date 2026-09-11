
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Boundary before the string starts
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                // Store the index of '('
                stack.push(i);

            } else {

                // ')' → try to match an '('
                stack.pop();

                // No matching '('
                if (stack.isEmpty()) {

                    // Current ')' becomes the new boundary
                    stack.push(i);

                } else {

                    // Valid substring length
                    int length = i - stack.peek();

                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}
