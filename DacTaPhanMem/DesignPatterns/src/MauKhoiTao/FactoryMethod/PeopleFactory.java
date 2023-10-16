package MauKhoiTao.FactoryMethod;

public class PeopleFactory {
    public static final People setPeople(PeopleType type){
        switch (type){
            case Student:
                return new Student();
            case Teacher:
                return new Teacher();
            default:
                throw new IllegalArgumentException("No people ...");
        }
    }
}
