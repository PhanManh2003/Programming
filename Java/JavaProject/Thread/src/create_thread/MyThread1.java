package create_thread;

public class MyThread1 extends Thread {
 // cách 1: kế thừa Thread class
    @Override
    public void run() {
        System.out.println("Thread 1 running");
    }
}
