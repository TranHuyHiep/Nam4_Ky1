package MauHanhVi.StatePattern.State2;

public class Plane implements State{
    private State takeOff;
    private State landing;
    private State fast;
    private State normal;
    private State slow;

    private State plane;

    public Plane() {
        takeOff = new PlaneTakeOff(this);
        landing = new PlaneLanding(this);
        fast = new PlaneFast(this);
        normal = new PLaneNormal(this);
        slow = new PlaneSlow(this);

        plane = landing;
    }

    public State getPlane() {
        return plane;
    }

    public void setPlane(State plane) {
        this.plane = plane;
    }

    public State getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(State takeOff) {
        this.takeOff = takeOff;
    }

    public State getLanding() {
        return landing;
    }

    public void setLanding(State landing) {
        this.landing = landing;
    }

    public State getFast() {
        return fast;
    }

    public void setFast(State fast) {
        this.fast = fast;
    }

    public State getNormal() {
        return normal;
    }

    public void setNormal(State normal) {
        this.normal = normal;
    }

    public State getSlow() {
        return slow;
    }

    public void setSlow(State slow) {
        this.slow = slow;
    }

    @Override
    public void display() {
        plane.display();
    }

    @Override
    public void takeOff() {
        plane.takeOff();
    }

    @Override
    public void landing() {
        plane.landing();
    }

    @Override
    public void fast() {
        plane.fast();
    }

    @Override
    public void slow() {
        plane.slow();
    }

    @Override
    public void normal() {
        plane.normal();
    }
}
