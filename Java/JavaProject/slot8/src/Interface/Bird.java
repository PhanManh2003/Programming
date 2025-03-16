package Interface;

public class Bird implements IFlyable, IEatable {

    @Override
    public void fly() {
        System.out.println("Bird flying");
    }

    @Override
    public void eat() {
        System.out.println("Bird eats");
    }
}
