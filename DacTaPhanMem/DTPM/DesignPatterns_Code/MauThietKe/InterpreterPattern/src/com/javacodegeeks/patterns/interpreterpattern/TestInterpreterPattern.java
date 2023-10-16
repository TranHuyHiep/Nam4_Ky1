package com.javacodegeeks.patterns.interpreterpattern;

import java.util.ArrayList;
import java.util.Stack;

public class TestInterpreterPattern {
	// Làm sao để ưu tiên nhân chia trước cộng trừ sau.()
	// (7 + 3 * 5 + 2) - (3 + 2) * 4.
	// ( 7 3 5 + *
	//
	public static String math(String tokenString){
		String[] split = tokenString.split(" ");
		ArrayList<String> toanTu = new ArrayList<>();
		Stack<Expression> stack = new Stack<>();
		for (int i =0; i< split.length; i++ ){
			int math = ExpressionUtils.isOperator(split[i]);
			if (math == 2) {
				Expression num1 = stack.pop();
				Expression num2 = new Number(Integer.parseInt(split[i+1] ) );
				Expression operator = ExpressionUtils.getOperator(split[i], num1,num2);
				int result = operator.interpret();
				stack.push(new Number(result));
				i++;
			}else if(math == 3){
				toanTu.add(split[i]);
			}
			else {
				Expression k = new Number(Integer.parseInt(split[i]));
				stack.push(k);
			}
		}
		for (String s : toanTu){
			Expression rightExpression = stack.pop();
			Expression leftExpression = stack.pop();
			Expression operator = ExpressionUtils.getOperator(s, leftExpression,rightExpression);
			int result = operator.interpret();
			stack.push(new Number(result));
		}
		return stack.pop().interpret() + "";
	}
	public static void main(String[] args) {

//		String tokenString = "7 3 5 * + 3 2 4 * + /";
//		Stack<Expression> stack = new Stack<>();
//		String[] tokenArray = tokenString.split(" ");
//		for (String s : tokenArray) {
//			if (ExpressionUtils.isOperator(s)) {
//				Expression rightExpression = stack.pop();
//				Expression leftExpression = stack.pop();
//				Expression operator = ExpressionUtils.getOperator(s, leftExpression,rightExpression);
//				int result = operator.interpret();
//				stack.push(new Number(result));
//			} else {
//				Expression i = new Number(Integer.parseInt(s));
//				stack.push(i);
//			}
//		}
//		System.out.println("( "+tokenString+" ): "+stack.pop().interpret());

		String tokenString = "( 7 + 3 * 5 + 2 ) - ( 3 + 2 ) * 4";
//		String tokenString = "( 7 + 3 * 5 + 2 )";
		String[] split = tokenString.split(" ");
		String s = "";
		String newS = "";
		boolean flag = false;
		for (int i =0; i< split.length; i++ ){
			int math = ExpressionUtils.isOperator(split[i]);
			if(flag && math != 1 && math != 0){
				newS += split[i] + " ";
			}
			if(math == 0){   // (
				flag = true;
				newS = "";
			}
			else if(math == 1){   // )
				flag = false;
				String e = math(newS);
				s += e + " ";
				continue;
			}
			else if(!flag) {
				s += split[i] + " ";
			}

		}
		if(!s.equals("")){
			s = math(s);
		}
		System.out.println(s);

	}



}
