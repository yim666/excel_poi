package yh.thread;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadpool {
    //2.创建线程池
    private static ExecutorService pool=Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
//        //创建5个任务
//        Runnable t1 = new nThread("t1");
//        nThread t2 = new nThread("t2");
//        nThread t3 = new nThread("t3");
//        nThread t4 = new nThread("t4");
//        nThread t5 = new nThread("t5");
//        //3.线程池执行任务
//        pool.execute(t1);
//        pool.execute(t2);
//        pool.execute(t3);
//        pool.execute(t4);
//        pool.execute(t5);
        ArrayList list = new ArrayList<>();
        list.add(new nThread("q1"));
        list.add(new nThread("q2"));
        list.add(new nThread("q3"));
        list.add(new nThread("q4"));
        //只适用于 实现Callable接口
        pool.invokeAll(list);
        //4.关闭线程池
        pool.shutdown();
    }
}

class nThread implements Callable{
    private  String name;
    public nThread(String s){
        name=s;
    }
//1.重写线程方法
    @Override
    public String call() {
        try {
            for (int i=0;i<2;i++){
                if (i==0){
                    pTimeMsg("Initializaton.......");
                }else {
                    pTimeMsg("Executing!!!!");
                }
                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name+"执行结束！";
    }

    private void pTimeMsg(String state){
        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
        System.out.println(state+"time-->"+"taskName:"+name+"==="+sf.format(d));
    }
}