
class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        String tmp = "";
        tmp = p1.name;
        p1.name = p2.name;
        p2.name = tmp;

        int a = p2.age;
        p2.age = p1.age;
        p1.age = a;
    }
}
