package yh;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tickets {
    int count=100;


    public synchronized void sale1(){
        count--;
        System.out.println("还有"+count+"张票");
    }

    private Lock lock=new ReentrantLock();
    public void sale2(){
        lock.lock();
        try {
            count--;
            System.out.println("还有"+count+"张票");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void sale3() throws InterruptedException {
        //限制等待锁时间
        if(lock.tryLock(1, TimeUnit.SECONDS)){
        try {
            count--;
            System.out.println("还有"+count+"张票");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    }

}
