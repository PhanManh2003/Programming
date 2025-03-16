package compare_2_Objects;

public class Student {

    public int id;
    public String name;
    public String address;

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Student) obj).id
                && this.name.equalsIgnoreCase(((Student) obj).name)
                && this.address.equalsIgnoreCase(
                        ((Student) obj).address);
    }
}
