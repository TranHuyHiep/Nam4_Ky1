package MauHanhVi.StatePattern;

//Bài toán:
//Người dùng muốn thay đổi trạng thái của chiếc điện thoại. Khi điện thoại tắt, người dùng ấn nút nguồn
//điện thoại sẽ mở và ngược lại
public interface State {
    void transitionTo(State state);

    void displayState();
}
