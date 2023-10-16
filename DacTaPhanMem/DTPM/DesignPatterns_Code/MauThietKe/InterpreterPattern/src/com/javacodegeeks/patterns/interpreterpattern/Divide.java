package com.javacodegeeks.patterns.interpreterpattern;

public class Divide implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Divide(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() / rightExpression.interpret();
    }
}
