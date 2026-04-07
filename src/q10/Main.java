import java.util.*;

public class Main {
    public static void main(String[] args) {

        // TODO: Evaluate a postfix (Reverse Polish Notation) expression
        //       Operands are non-negative integers, operators are: + - * /
        //       Use a stack to evaluate
        //       Input: single line, tokens separated by spaces
        //       Output: integer result
        //
        // Input: 5 1 2 + 4 * + 3 -
        // Output: 14
        //
        // Explanation: 5 + ((1+2)*4) - 3 = 5 + 12 - 3 = 14


        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();
        String[] tokens = line.split(" ");
        
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int res = calculate(a, b, token);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        System.out.println(stack.pop());
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int calculate(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return 0;
        }
    }
}
