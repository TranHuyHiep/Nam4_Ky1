package MauHanhVi.StatePattern.State2;

public class RunMain {
    public static void main(String[] args) {
        State plane = new Plane();

        plane.takeOff();
        plane.fast();
        plane.landing();

        plane.slow();
        plane.normal();
        plane.slow();
        plane.landing();
    }
}
