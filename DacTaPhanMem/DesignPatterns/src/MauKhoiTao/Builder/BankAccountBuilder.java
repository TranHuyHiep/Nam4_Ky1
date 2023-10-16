package MauKhoiTao.Builder;

public class BankAccountBuilder implements AccountBuilder{
    private final Account account = new Account("Nguyen Ngu", "Ngu123456");
    @Override
    public void buildPhone() {
        account.setPhone("0362871301");
    }
    @Override
    public void buildOwner() {
        account.setOwner("Nguyễn Thị Ngũ");
    }
    @Override
    public void buildBranch() {
        account.setBranch("Branch 1");
    }
    @Override
    public void buildBalance() {
        account.setBalance(10);
    }
    @Override
    public void buildInterestRate() {
        account.setInterestRate(5);
    }
    @Override
    public Account getAccount() {
        return account;
    }
}
