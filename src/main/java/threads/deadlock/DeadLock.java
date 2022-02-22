package threads.deadlock;

public class DeadLock { // The Program runs but does not stops as it goes into the deadlock state as both the objects require the key holded by each other to perform next operation.

  public static void main(String[] args) throws InterruptedException {
    SimpleSync call = new SimpleSync();

    /**
     * TODO: Create two runnable and thread. Call the first method inside first runnable
     * TODO: and second method inside the second runnable. Start both the threads and join
     */
    /*Runnable runnable1=new Runnable() {
      @Override
      public void run() {
        call.first();
      }
    };
    Runnable runnable2=new Runnable() {
      @Override
      public void run() {
        call.second();
      }
    };
    Thread t1=new Thread(runnable1);
    Thread t2=new Thread(runnable2);*/
    //Use of method reference to avoid creating a runnable
    Thread t1=new Thread(call::first);
    Thread t2=new Thread(call::second);
    t1.start();
    t2.start();

  }
}
