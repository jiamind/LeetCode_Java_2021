import java.util.Stack;

/**
 * 772. Basic Calculator III
 * Idea: treat input as a sum of sum components. 
 * |- treat "()" as a new input. 
 * |- evaluate when we read an operator:
 * |- if prev operator is '+', add it to the stack
 * |- if prev operator is '-', * -1 then add it to the stack
 * |- if prev operator is '*' or '/', retreive the previous result and apply the operator
 * Time complexity:
 * |- iterate through each input, do a substring O(N * N)
 * |- while stack not empty, pop: O(N)
 * |- Therefore, O(N^2). Can be optimized to O(N) if pass start and end index of the string
 * Space complexity:
 * |- <Stack> stack: O(N)
 */
public class BasicCalculatorIII {
    public int calculate(String s) {
        int num = 0;
        char prevSign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                num = num * 10 + Character.getNumericValue(currentChar);
            } else if (currentChar == '(') {
                int left = 1;
                int j = i;
                while (left > 0) {
                    j++;
                    if (s.charAt(j) == '(') {
                        left++;
                    } else if (s.charAt(j) == ')') {
                        left--;
                    }
                }
                
                num = calculate(s.substring(i + 1, j + 1));
                i = j;
            }
            
            if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || i == s.length() - 1) {
                if (prevSign == '+') {
                    stack.push(num);
                } else if (prevSign == '-') {
                    stack.push(num * -1);
                } else if (prevSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (prevSign == '/') {
                    stack.push(stack.pop() / num);
                }

                num = 0;
                prevSign = currentChar;
            }
        }

        int result = 0;
        while (!stack.empty()) {
            result += stack.pop();
        }

        return result;
    }
}
