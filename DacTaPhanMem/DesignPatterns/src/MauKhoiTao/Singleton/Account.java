package MauKhoiTao.Singleton;

public class Account {
    private static Account account= null;
    private Account() {
        System.out.println("Khởi tạo account mới");
    }
    public static Account singletonAccount(){
        if(account == null){
            synchronized ( Account.class){
                if(account == null){
                    account = new Account();
                }
            }
        }
        return account;
    }
}
