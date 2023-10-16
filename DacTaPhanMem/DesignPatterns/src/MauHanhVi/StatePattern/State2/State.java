package MauHanhVi.StatePattern.State2;

public interface State {
    void display();

    void takeOff(); // cất cánh
    void landing(); // hạ cánh

    void fast(); // nhanh
    void slow (); // chậm
    void normal(); // bình thường
}
