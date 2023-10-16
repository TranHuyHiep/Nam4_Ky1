package MauKhoiTao.Singleton;

//Bài toán: Khi muốn tạo 1 đối tượng duy nhất xuyên suốt chương trình
public class TestSingleton {
    public static void main(String[] args) {
        Account account = Account.singletonAccount();

        account = Account.singletonAccount();

    }
}
