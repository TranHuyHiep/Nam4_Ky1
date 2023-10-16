package MauHanhVi.StatePattern;

public class testStatePattern {
    public static void main(String[] args) {
        SmartphoneContext smartphone = new SmartphoneContext();

        smartphone.displayState();
        smartphone.toggle();
        smartphone.displayState();
        smartphone.toggle();
        smartphone.displayState();
        smartphone.toggle();
        smartphone.displayState();
    }
}
