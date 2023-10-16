package MauKhoiTao.Builder;

public class TestBuilder {
    public static void main(String[] args) {
        AccountBuilder accountBuilder = new BankAccountBuilder();
        AccountDirector director = new AccountDirector(accountBuilder);
        director.build();
        Account account = accountBuilder.getAccount();
        System.out.println(account);

        accountBuilder = new SavingAccountBuilder();
        director = new AccountDirector(accountBuilder);
        director.build();
        Account account1 = accountBuilder.getAccount();
        System.out.println(account1);
    }

}
