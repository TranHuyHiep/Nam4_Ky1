package MauHanhVi.InterpreterPattern;

public class Multi implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;
    public Multi(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }
}
