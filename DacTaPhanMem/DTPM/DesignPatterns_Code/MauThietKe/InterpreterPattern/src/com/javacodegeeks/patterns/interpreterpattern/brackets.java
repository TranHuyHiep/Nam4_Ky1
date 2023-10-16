package com.javacodegeeks.patterns.interpreterpattern;

import java.util.Queue;
import java.util.Stack;

public class brackets implements Expression{
    Queue<String> queue;

    public brackets(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public int interpret() {
        Stack<Expression> stack = new Stack<>();
        while(!queue.isEmpty()){
            String s = queue.poll();
//            if(ExpressionUtils.isOperator(s)){
//                Expression rightExpression = stack.pop();
//                Expression leftExpression = stack.pop();
//                Expression operator = ExpressionUtils.getOperator(s, leftExpression,rightExpression);
//                int result = operator.interpret();
//                stack.push(new Number(result));
//            } else {
//                Expression i = new Number(Integer.parseInt(s));
//                stack.push(i);
//            }
        }
        return stack.pop().interpret();
    }
}
