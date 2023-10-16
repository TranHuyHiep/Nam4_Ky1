package MauHanhVi.StatePattern.State2;

public class PlaneLanding implements State{
    private Plane plane;

    public PlaneLanding(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void display() {
        System.out.println("The plane is landing!");
    }

    @Override
    public void takeOff() {
        System.out.println("Plane is take off!");
        plane.setPlane(plane.getTakeOff());
    }

    @Override
    public void landing() {
        System.out.println("The plane is landing");

    }

    @Override
    public void fast() {
        System.out.println("No can fast....");
    }

    @Override
    public void slow() {
        System.out.println("No can slow ...");

    }

    @Override
    public void normal() {
        System.out.println("No can normal ...");
    }
}
