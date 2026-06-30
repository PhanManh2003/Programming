package create_thread;


/*
Thread priority:
 Thread.MAX_PRIORITY : constant value of 10
 Thread.NORM_PRIORITY : constant value of 5, default
 Thread.MIN_PRIORITY : constant value of 1
Important Methods:
 setPriority()
 getPriority()



-> 1 thread mới vô runnable state thì có priority cao nhất, hơn cả running thread
nhưng chưa phải là điều kiện đủ để scheduler chọn nó vô running. Trong đa số 
trường hợp thì thread running có priority cao hơn các thread trong pool


Use thread priorities as a way to improve efficiency:
Ví dụ như UI thread ưu tiên hơn log Thread


JAVA có 2 loại thread: user thread và daemon thread.

The characteristics of the daemon threads are:
- They work in the background providing service to other threads.
- They are fully dependent on the user threads.
- JVM terminates when all non-daemon (user) threads have finished execution
- dùng .setDaemon() để chỉ định 1 thread là daemon
 */
public class ThreadPriority {

    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(
                        Thread.currentThread().getName()
                );
            }
        };

        Thread low = new Thread(task, "LOW");
        Thread high = new Thread(task, "HIGH");

        low.setPriority(1);
        high.setPriority(10);
//  In most cases, the running thread will be of equal or greater priority than the
// highest priority threads in the pool -> low vẫn có thể chạy trước 
        low.start();
        high.start();
    }
}
