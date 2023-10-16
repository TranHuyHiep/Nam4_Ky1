package MauCauTruc.Adapter;


//Bài toán: Công nghệ cũ sử dụng họ tên nhưng công nghệ mới muốn tách họ và tên riêng.

public class TestAdapter {
    public static void main(String[] args) {
        User user = new UserImpl("Nguyễn Thị Ngũ");
        Customer customer = new UserImplCustomer(user);

        testAdapter(customer);
    }
    public static void testAdapter(Customer customer){
        System.out.println("First Name: " + customer.getFirstName());
        System.out.println("Last Name: " + customer.getLastName());
    }
}
