/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfix;

import postfix.jsjf.*;
import java.util.StringTokenizer;

/**
 * PostfixEvaluator this modification of our stack example uses a stack to
 * create an expression tree from a VALID integer postfix expression and then
 * uses a recursive method from the ExpressionTree class to evaluate the tree.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class PostfixEvaluator {

    private final char ADD = '+';
    private final char SUBTRACT = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final char POWER = '^';
    private LinkedStack<Integer> stack;

    /**
     * Sets up this evaluator by creating a new stack.
     */
    public PostfixEvaluator() {

        stack = new LinkedStack<>();

    }

    /**
     * Evaluates the specified postfix expression. If an operand is encountered,
     * it is pushed onto the stack. If an operator is encountered, two operands
     * are popped, the operation is evaluated, and the result is pushed onto the
     * stack.
     *
     * @param expr String representation of a postfix expression
     * @return int value of the given expression
     */

    public int evaluate(String expr) {
        int op1, op2, result = 0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expr);

        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();

            if (isOperator(token)) {
                op2 = (stack.pop());
                op1 = (stack.pop());
                result = evalSingleOp(token.charAt(0), op1, op2);
                stack.push(result);

            } else {

                stack.push(Integer.parseInt(token));

            }

        }
        return stack.peek();
    }

    /**
     * Determines if the token is an Operator, if it is, it will return true, if
     * not it will return false
     * @param token
     * @return true or false
     */
    private boolean isOperator(String token) {

        if ("+".equals(token) || "-".equals(token) || "*".equals(token)
                || "/".equals(token) || "^".equals(token)) {

            return true;
        } else {
            return false;
        }

    }

    /**
     *Will evaluate the two operands with the different operations
     * @param operation(Add, Subtract, Multiply, Divide, Power)
     * @param op1 first number
     * @param op2 second number
     * @return result result of operation
     */
    private int evalSingleOp(char operation, int op1, int op2) {
        int result = 0;
        switch (operation) {
            case ADD:
                result = op1 + op2;
                return result;
            case SUBTRACT:
                result = op1 - op2;
                return result;
            case MULTIPLY:
                result = op1 * op2;
                return result;
            case DIVIDE:
                result = op1 / op2;
                return result;
            case POWER:
                result = (int) Math.pow(op1, op2);
            default:
                break;
        }
        return result;

    }
}
