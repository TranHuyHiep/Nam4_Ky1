package MauKhoiTao.Builder;

public interface AccountBuilder {
    void buildPhone();
    void buildOwner();
    void buildBranch();
    void buildBalance();
    void buildInterestRate();
    Account getAccount();
}
