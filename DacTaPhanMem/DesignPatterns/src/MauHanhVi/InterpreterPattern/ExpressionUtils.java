package MauHanhVi.InterpreterPattern;

public class ExpressionUtils {
    public static boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
        return false;
    }
    public static Expression getOperator(String s, Expression left,	Expression right) {
        switch (s) {
            case "+":
                return new Add(left, right);
            case "-":
                return new Sub(left, right);
            case "*":
                return new Multi(left, right);
            case "/":
                return new Div(left, right);
        }
        return null;
    }
}
