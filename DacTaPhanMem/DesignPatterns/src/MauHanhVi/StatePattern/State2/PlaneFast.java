package MauHanhVi.StatePattern.State2;

public class PlaneFast implements State{
    private Plane plane;
    public PlaneFast(Plane plane) {
        this.plane = plane;
    }
    @Override
    public void display() {
        System.out.println("The plane is flying fast");
    }

    @Override
    public void takeOff() {
        System.out.println("The plane has taken off");
        plane.setPlane(plane.getTakeOff());
    }

    @Override
    public void landing() {
        System.out.println("Flying fast can't land");
    }

    @Override
    public void fast() {
        System.out.println("Fast speed ...");
        plane.setPlane(plane.getFast());
    }

    @Override
    public void slow() {
        System.out.println("Không chuyển được");

    }

    @Override
    public void normal() {
        System.out.println("Normal speed ...");
        plane.setPlane(plane.getNormal());
    }
}
