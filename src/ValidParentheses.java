import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpenParenthese(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (isClosedParenthese(s.charAt(i))) {
                if (stack.isEmpty()) return false;
                Character lastParenthese = stack.pop();
                if (!parenthesesMatch(lastParenthese.charValue(), s.charAt(i))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpenParenthese(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isClosedParenthese(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean parenthesesMatch(char open, char closed) {
        return (open == '(' && closed == ')') ||
                (open == '[' && closed == ']') ||
                (open == '{' && closed == '}');
    }
}