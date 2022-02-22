package threads;

/**
 * 1. Use this file to write your first thread program using Runnable interface
 * 2. When you are done convert the same program by extending the Thread class
 * */
public class FirstThread /*implements Runnable*/ extends Thread{ // one can extend only one class, but one class & interface can be present also we can implement many interfaces

  /*public static void main(String[] args) { ////We can also write implements runnable but then we are required to have abstract method run
    Runnable runnable=new Runnable() {
      @Override
      public void run() {
      String threadname=Thread.currentThread().getName();
        System.out.println("I am running in :"+threadname +" thread");
      }
    };
  Thread t1=new Thread(runnable,"mythread-t1");//Runnable object is passed to the constructor of thread
    Thread t2=new Thread(runnable,"mythread-t2");
    t1.start();
    t2.start();*/

  //******** @ second method ********
  /*public static void main(String[] args) {
    Runnable runnable=new FirstThread(); // It is the second method where we provide class name for runnable interface
    Thread t1=new Thread(runnable,"mythread-t1");
    t1.start();
    Thread t2=new Thread(runnable,"mythread-t2");
    t2.start();
  }
  @Override
  public void run() {
    String threadname=Thread.currentThread().getName();
    System.out.println("I am running in :"+threadname +" thread");
  }*/
  //**** @ Third way **** as when we have no other functionality other than running thread extend it, but when other functionality is also required , use implements runnable.
  /*public static void main(String[] args) {
    Runnable runnable=new FirstThread(); // It is the second method where we provide class name for runnable interface
    Thread t1=new Thread(runnable,"mythread-t1");
    t1.start();
    Thread t2=new Thread(runnable,"mythread-t2");
    t2.start();
  }*/
 //******** @ fourth way as we are extending so just the instance of the class can be used *****
  public static void main(String[] args) throws InterruptedException {
    //System.out.println(Thread.currentThread().getName());
    FirstThread t1=new FirstThread();
    // If we use t1.run() : it will run in the main thread or current thread, as program does not runs as a thread.
    t1.start();
    // We ensure that thread 1 runs first
    t1.join();//It will wait to join it to the main thread, i.e once t1 execution is done & it dies then only ,it will  move to other thread for execution.
    FirstThread t2=new FirstThread();
    t2.start();
    //System.out.println(Thread.currentThread().getName());

  }
  @Override
  public void run() {
    String threadname = Thread.currentThread().getName();
    System.out.println("I am running in :" + threadname + " thread");
  }
}
