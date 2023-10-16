package MauKhoiTao.Builder;

public class Account {
    private String email;
    private String password;
    private String phone;
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;

    public Account() {
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        String s = "";
        s += "\nEmail: " + email;
        s += "\nPassword: " + password;
        s += "\nPhone: " + phone;
        s += "\nOwner: " + owner;
        s += "\nBranch: " + branch;
        s += "\nBalance: " + balance;
        s += "\nInterestRate: " + interestRate;
        return s;
    }
}
