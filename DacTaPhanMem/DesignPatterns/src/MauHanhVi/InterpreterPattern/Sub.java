package MauHanhVi.InterpreterPattern;

public class Sub implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;
    public Sub(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}
