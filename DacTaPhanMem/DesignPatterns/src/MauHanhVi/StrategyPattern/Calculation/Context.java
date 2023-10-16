package MauHanhVi.StrategyPattern.Calculation;

public class Context {
    private Calculation calculation;
    public Context(Calculation calculation) {
        this.calculation = calculation;
    }
    public double execute (double num1 , double num2){
        return calculation.calculate(num1, num2);
    }
}
