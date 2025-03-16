package down_casting;

public class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Bark");
    }

    void fetch() {
        System.out.println("Fetching...");
    }
}
