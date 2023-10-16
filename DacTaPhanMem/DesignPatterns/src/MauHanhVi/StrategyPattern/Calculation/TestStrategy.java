package MauHanhVi.StrategyPattern.Calculation;

public class TestStrategy {
    public static void main(String[] args) {
        Context context = new Context(new Addition());
        System.out.println("Addition = " + context.execute(5, 3));

        context = new Context(new Subtraction());
        System.out.println("Subtraction = " + context.execute(5, 3));

        context = new Context(new Multiplication());
        System.out.println("Multiplication = " + context.execute(5, 3));

        context = new Context(new Division());
        System.out.println("Division = " + context.execute(5, 3));
    }
}
