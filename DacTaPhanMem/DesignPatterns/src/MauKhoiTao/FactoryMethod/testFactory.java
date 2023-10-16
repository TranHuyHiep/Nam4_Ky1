package MauKhoiTao.FactoryMethod;

public class testFactory {
    public static void main(String[] args) {
        People people = PeopleFactory.setPeople(PeopleType.Student);
        System.out.println(people.getPeople());

        people = PeopleFactory.setPeople(PeopleType.Teacher);
        System.out.println(people.getPeople());
    }
}
