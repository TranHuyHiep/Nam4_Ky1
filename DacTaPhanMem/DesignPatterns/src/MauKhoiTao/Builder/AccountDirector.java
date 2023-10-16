package MauKhoiTao.Builder;

public class AccountDirector {
    private AccountBuilder accountBuilder;

    public AccountDirector(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    public void build(){
        accountBuilder.buildPhone();
        accountBuilder.buildOwner();
        accountBuilder.buildBranch();
        accountBuilder.buildBalance();
        accountBuilder.buildInterestRate();
    }
}
