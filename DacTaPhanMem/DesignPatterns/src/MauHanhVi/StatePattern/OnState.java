package MauHanhVi.StatePattern;

public class OnState implements State{
    private SmartphoneContext smart;
    public OnState(SmartphoneContext smart){
        this.smart = smart;
    }
    @Override
    public void transitionTo(State state) {
        this.smart.setCurrentState(state);
    }
    @Override
    public void displayState() {
        System.out.println("Smartphone is ON!");
    }
}
