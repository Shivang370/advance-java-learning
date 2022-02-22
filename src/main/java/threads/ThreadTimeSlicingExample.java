package threads;

/**
 * This example shows that the thread's execution depends on the OS implementation of time slicing
 * and we can’t control their execution. However, we can set threads priority but even then it doesn’t
 * guarantee that higher priority thread will be executed first.
 *
 * Running this program several times will show that there is no pattern of threads starting and end.
 *
 * */
public class ThreadTimeSlicingExample {
  public static void main(String[] args) {

    Runnable r = new Runnable() {
      @Override
      public void run() {
        System.out.println("Starting thread: " + Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Ending thread: " + Thread.currentThread().getName());
      }
    };

    Thread t1 = new Thread(r, "t1");
    Thread t2 = new Thread(r, "t2");
    t1.start();
    t2.start();
  }
}
