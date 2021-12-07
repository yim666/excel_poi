package yh.thread;

public class runnable {
    public static void main(String[] args) {
        Runnable r = new tRunnable();
        Thread thread1 = new Thread(r,"t1");
        Thread thread2 = new Thread(r,"t2");
        Thread thread3 = new Thread(r,"t3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class tRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread()+"runnable.....");
    }
}
