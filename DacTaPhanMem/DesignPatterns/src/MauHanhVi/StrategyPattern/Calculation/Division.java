package MauHanhVi.StrategyPattern.Calculation;

public class Division implements Calculation{
    @Override
    public double calculate(double a, double b) {
        return b == 0 ? 0 : a /b;
    }
}
