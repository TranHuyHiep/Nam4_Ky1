package MauHanhVi.InterpreterPattern;

import java.util.Stack;

public class TestInterpreterPattern {
    public static void main(String[] args) {
        String tokenString = "7 3 5 * + 3 2 4 * - /";
		Stack<Expression> stack = new Stack<>();
		String[] tokenArray = tokenString.split(" ");
		for (String s : tokenArray) {
			if (ExpressionUtils.isOperator(s)) {
				Expression rightExpression = stack.pop();
				Expression leftExpression = stack.pop();
				Expression operator = ExpressionUtils.getOperator(s, leftExpression,rightExpression);
				int result = operator.interpret();
				stack.push(new Number(result));
			} else {
				Expression i = new Number(Integer.parseInt(s));
				stack.push(i);
			}
		}
		System.out.println("KQ = " + stack.pop().interpret());
    }
}
