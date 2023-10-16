package MauCauTruc.Adapter;

public class UserImpl implements User{
    private String name;

    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
