package MauCauTruc.Adapter;

public class UserImplCustomer implements Customer{
    private User user;
    private String firstName;
    private String lastName;
    public UserImplCustomer(User user) { this.user = user; setProp(); }
    @Override
    public String getFirstName() {
        return this.firstName;
    }
    @Override
    public String getLastName() {
        return this.lastName;

    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    private void setProp(){
        String []split = this.user.getName().split(" ");
        StringBuilder name = new StringBuilder();
        for (int i = 0; i< split.length-2; i++){
            name.append(split[i]).append(" ");
        }
        name.append(split[split.length - 2]);
        this.firstName = name.toString();

        this.setLastName(split[split.length-1]);
    }
}
