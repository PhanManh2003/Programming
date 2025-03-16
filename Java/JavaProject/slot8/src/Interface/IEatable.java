package Interface;

public interface IEatable {

    void eat();

    default void defaultMethod() {
        System.out.println("This is a default method.");
    }

    static void staticMethod() {
        System.out.println("static method");
    }

}
