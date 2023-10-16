package MauHanhVi.StatePattern;

public class OffState implements State{
    private SmartphoneContext smart;
    public OffState(SmartphoneContext smart) {
        this.smart = smart;
    }
    @Override
    public void transitionTo(State state) {
        smart.setCurrentState(state);
    }
    @Override
    public void displayState() {
        System.out.println("Smartphone is OFF!");
    }
}
