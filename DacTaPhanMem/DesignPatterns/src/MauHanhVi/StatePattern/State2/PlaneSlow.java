package MauHanhVi.StatePattern.State2;

public class PlaneSlow implements State {
    private Plane plane;

    public PlaneSlow(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void display() {
        System.out.println("The plane is flying slowly");
    }

    @Override
    public void takeOff() {
        System.out.println("Máy bay đang bay");
    }

    @Override
    public void landing() {
        System.out.println("The plane is landing!");
        plane.setPlane(plane.getLanding());
    }

    @Override
    public void fast() {
        System.out.println("Can't fast speed ...");
    }

    @Override
    public void slow() {
        System.out.println("Slow speed ...");
    }

    @Override
    public void normal() {
        System.out.println("Normal speed ...");
        plane.setPlane(plane.getNormal());
    }
}
