package Queue;

public class Person {

    String name;
    int age;

    Person() {
    }

    Person(String xName, int xAge) {
        name = xName;
        age = xAge;
    }

    @Override
    public String toString() {
        return ("(" + name + ", " + age + ") ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
