package MauKhoiTao.Builder;

public class SavingAccountBuilder implements AccountBuilder{
    private final Account account = new Account("Ngo Khai", "khaingo");
    @Override
    public void buildPhone() {
        account.setPhone("0394229171");
    }
    @Override
    public void buildOwner() {
        account.setOwner("Ngô Văn Khải");
    }
    @Override
    public void buildBranch() {
        account.setBranch("Branch 2");
    }
    @Override
    public void buildBalance() {
        account.setBalance(100);
    }
    @Override
    public void buildInterestRate() {
        account.setInterestRate(3);
    }
    @Override
    public Account getAccount() {
        return account;
    }
}
