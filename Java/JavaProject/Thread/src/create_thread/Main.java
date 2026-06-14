package create_thread;

/**
 * =============== THREAD LÀ GÌ ========================= Mỗi process là 1
 * program đang chạy : google chrome, word, excel,...
 *
 * Mỗi process cần làm nhiều task , mỗi task dc thực hiện bởi 1 thread. A thread
 * is the smallest unit of executable code in an application that performs a
 * particular job or task.
 *
 * Thread có biến local , program counter và lifeline riêng.
 *
 * Các thread chia sẻ 1 vùng nhớ chung.
 *
 * Tại 1 thời điểm chỉ có 1 thread chạy trên 1 core CPU.
 *
 * ==================================================================
 */

/*
Thread State: Xem ảnh slide ( 6 trạng thái : new, runnable, running, blocked,
waiting , timed-waiting, terminated)

BLOCKED : thread này đang chờ để lấy lock ( chìa khoá ) của method synchronized 
đang dc giữ bởi thread khác.
    

WAITING: chờ vô thời hạn. 

VD:
        object.wait();      // → WAITING ( đợi tín hiệu từ thread khác)
        thread1.join();      // → WAITING (chờ thread1 chạy xong) ( dùng nhiều)
        LockSupport.park(); // → WAITING (dùng khi bạn muốn “treo” một thread   
            và chủ động quyết định khi nào đánh thức nó bằng unpark(). ít dùng)

TIMED_WAITING: chờ có thời hạn. ( tự thức dậy hoặc có thread khác đánh thức)

VD: 
            Thread.sleep(1000);          // ngủ ko nhả lock
            object.wait(1000);           // đợi tối đa 1s (có mỗi thằng này nhả lock)
            thread1.join(1000);           // Đợi tối đa 1 giây cho thread1 kết thúc.
            LockSupport.parkNanos(1000); // TIMED_WAITING

TERMINATED: thread đã run xong , ko thể start lại.

 */
 /*
 Thread class cung cấp các constructor và method để thao tác trên 1 thread.
 
# Các constructor của Thread Class:
 
  Thread() Thread(String name) Thread(Runnable r) Thread(Runnable r, String
  name)
# Các method của Thread Class:

      static currentThread() : Lấy thread hiện tại
      getName() : Lấy tên thread
      start() : Khởi động thread, JVM tự gọi .run() khi có cơ hội
      run() : Phương thức entry point của thread ( giống main của app)
      static sleep() :  Ngủ trong x milliseconds,  Thread.sleep() làm ngủ thread ĐANG THỰC THI dòng code này!
      isAlive() :  Kiểm tra thread còn sống không
      static activeCount() : Đếm số thread đang hoạt động
      interrupt() :  Gửi tín hiệu ngắt thread
      static yield() : Nhường CPU cho thread khác
      join() : Đợi thread gọi join() kết thúc
 
 */
public class Main {

    public static void main(String[] args) {
        /**
         * 2 cách tạo thread.
         */
//        MyThread1 t1 = new MyThread1();
//        t1.start(); // output: thread 1 running
//
//        Runnable r = new MyThread2();
//        Thread t2 = new Thread(r);
//        t2.start(); //Tạo thread mới để chạy object Runnable này; output: thread 2 running

        /**
         * currentThread(): trả về ref của thread đang chạy đang code này
         * getName(): lấy tên thread
         */
//        Thread t = Thread.currentThread();
//        System.out.println("Thread hiện tại: " + t.getName());     // Output: Thread hiện tại: main


        /**
         * start(): starts the execution of the thread. JVM calls the run()
         * method on the thread
         *
         * run() - Phương thức chứa code của thread ( entry point)
         *
         * class MyThread extends Thread {
         *
         * @Override public void run() { // Code thread sẽ thực thi ở đây
         * System.out.println("Thread đang làm việc"); } }
         *
         */
        /**
         * isAlive(): kiểm tra thread còn sống ko          *
         */
//        Thread t = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//            }
//        });
//
//        System.out.println("Trước start: " + t.isAlive()); // false
//
//        t.start();
//        System.out.println("Sau start: " + t.isAlive()); // true
//
//        try {
//            t.join(); // đợi thread chết
//        } catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        System.out.println("Sau khi chết: " + t.isAlive()); // false
        /**
         * activeCount(): đếm số thread đang hoạt động
         *
         */
//         System.out.println("Số thread: " + Thread.activeCount());  // 1 (main)
//        
//        Thread t1 = new Thread(() -> {
//            try { Thread.sleep(2000); } catch (InterruptedException e) {}
//        });
//        Thread t2 = new Thread(() -> {
//            try { Thread.sleep(2000); } catch (InterruptedException e) {}
//        });
//        
//        t1.start();
//        t2.start();
//        
//        System.out.println("Số thread: " + Thread.activeCount());  // 3 (main + t1 + t2)
        /**
         * interrupt() - Gửi tín hiệu ngắt thread
         */
        /*
static yield() - Nhường CPU cho thread khác ( hiếm khi dùng )

Nó chỉ là gợi ý (hint) cho scheduler:

“Tôi sẵn sàng nhường CPU nếu có thread khác muốn chạy.”

Nhưng:

JVM/OS có thể bỏ qua hoàn toàn.
         */
 /*

Interrupt: gửi tín hiệu xin hãy dừng lại . Kiểu như:
📢 Bạn GỌI ĐIỆN cho người đang ngủ
🛌 Nếu họ đang NGỦ → điện thoại reo → họ THỨC DẬY
🏃 Nếu họ đang CHẠY BỘ → điện thoại reo nhưng họ KHÔNG NGHE → phải TỰ KIỂM TRA điện thoại

 Quy tắc vàng:

✅ Luôn kiểm tra Thread.interrupted() hoặc isInterrupted() trong vòng lặp
✅ Luôn catch InterruptedException khi dùng sleep()/wait()/join()
✅ Dọn dẹp tài nguyên trước khi thoát thread
         */
        Thread t = new Thread(() -> {
            try {
                System.out.println("Bắt đầu ngủ 10 giây...");
                Thread.sleep(10000);  // t ngủ 10 giây
                System.out.println("Ngủ xong!");  // ← KHÔNG BAO GIỜ IN RA
            } catch (InterruptedException e) {
                System.out.println("Bị đánh thức giữa chừng!");  // ← IN RA ĐÂY
            }
        });

        t.start();
        try {
            Thread.sleep(2000);  // Main ngủ 2 giây để cho t nó ngủ
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        t.interrupt();  // Đánh thức t thread đang ngủ khi mới ngủ 2s

// Nếu thread đang chạy
//        Thread t = new Thread(() -> {
//            for (int i = 0; i < 1000000; i++) {
//                // Kiểm tra interrupt flag
//                if (Thread.interrupted()) {  // hoặc Thread.currentThread().isInterrupted()
//                    System.out.println("Nhận được tín hiệu dừng tại i=" + i);
//                    return;  // Dừng thread
//                }
//                System.out.println(i);
//            }
//        });
//
//        t.start();
//        try {
//            Thread.sleep(1); // ← Main thread ngủ 100ms, CHỜ thread t chạy cho kết quả 1 ít
//        } catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        t.interrupt(); // dừng sớm

    }
}
