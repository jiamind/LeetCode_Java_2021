import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i< tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = calculate(operand1, operand2, tokens[i]);
                stack.push(result);
            } else {
                int value = Integer.parseInt(tokens[i]);
                stack.push(value);
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || 
            token.equals("-") ||
            token.equals("*") ||
            token.equals("/");
    }

    private int calculate(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2; 
        }
    }
}