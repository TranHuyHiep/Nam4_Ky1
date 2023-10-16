package MauHanhVi.StatePattern;

import java.util.HashMap;
import java.util.Map;

public class SmartphoneContext {
    private Map<State, State> smartMap = new HashMap<>();
    private State currentState;
    public SmartphoneContext() {
        State onState = new OnState(this);
        State offState = new OffState(this);
        this.smartMap.put(onState, offState);
        this.smartMap.put(offState, onState);
        currentState = offState;
    }
    public void setCurrentState(State state) {
        this.currentState = state;
    }
    public void displayState() {
        this.currentState.displayState();
    }
    public void toggle() {
        this.currentState.transitionTo(smartMap.get(currentState));
    }
}
