package create_thread;


public class ThreadYield {

    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(
                        Thread.currentThread().getName() + ": " + i
                );

                Thread.yield(); // Nhường lượt cho thread khác
// Kết quả: Thread t1 và t2 sẽ xen kẽ nhau (không chắc chắn 100%).
            }
        }
    }

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }
}
