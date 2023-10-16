package MauHanhVi.StatePattern.State2;

public class PlaneTakeOff implements State{
    private Plane plane;

    public PlaneTakeOff(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void display() {
        System.out.println("The plane is taking off!");
    }

    @Override
    public void takeOff() {
        System.out.println("The plane is take off!");

    }

    @Override
    public void landing() {
        System.out.println("The plane is landing");
        plane.setPlane(plane.getLanding());

    }

    @Override
    public void fast() {
        System.out.println("Fast speed ...");
        plane.setPlane(plane.getFast());

    }

    @Override
    public void slow() {
        System.out.println("Slow speed ...");
        plane.setPlane(plane.getSlow());
    }

    @Override
    public void normal() {
        System.out.println("Normal speed ...");
        plane.setPlane(plane.getNormal());
    }
}
