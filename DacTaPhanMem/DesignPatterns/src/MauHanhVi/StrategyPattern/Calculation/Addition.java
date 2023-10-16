package MauHanhVi.StrategyPattern.Calculation;

public class Addition implements Calculation{
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
