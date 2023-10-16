package com.javacodegeeks.patterns.interpreterpattern;

public class ExpressionUtils {

	public static int isOperator(String s) {
		if (s.equals("+") || s.equals("-"))
			return 3;
		if(s.equals("*") || s.equals("/"))
			return 2;
		if(s.equals("(") )
			return 0;
		if(s.equals(")"))
			return 1;
		return -1;
	}
	
	public static Expression getOperator(String s, Expression left,	Expression right) {
		switch (s) {
		case "+":
			return new Add(left, right);
		case "-":
			return new Substract(left, right);
		case "*":
			return new Product(left, right);
		case "/":
			return new Divide(left, right);
		}
		return null;
	}

}
