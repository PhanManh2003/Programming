 
package create_thread;

 
public class MyThread2 implements Runnable {
    // cách 2 : implement lớp runnable
    @Override
    public void run() {
        System.out.println("Thread 2 running");
    }
    
}
