package yh.thread;

public class thread {
    public static void main(String[] args) throws InterruptedException {
        nTh nthread = new nTh();
////        n.setName("t1--");
////        n.start();
//
        Thread thread1 = new Thread(nthread,"t1");
        Thread thread2 = new Thread(nthread,"t2");
        Thread thread3 = new Thread(nthread,"t3");
        thread1.start();
        thread2.start();
//        thread2.sleep(5000);
        thread3.start();
        thread3.notify();
//        thread3.join();
        System.out.println("....");
//        new nTh("t1").start();
//        new nTh("t2").start();
//        new nTh("t3").start();
    }
}
class nTh extends Thread{
    private String name;

    public nTh() {

    }

    public nTh(String n){
        name=n;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread()+name+"-->thread....");
    }
}
