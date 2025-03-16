package staticc;

public class Counter {

    static int count;

    public Counter() {
        count++;
        System.out.println(count);
    }
}
