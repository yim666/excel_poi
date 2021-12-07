package yh.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                new ThreadPoolExecutor.AbortPolicy());

        //当任务线程数量 小于 核心线程数+阻塞队列之和时 ,
        //     不会启用非核心线程（maximumPoolSize-corePoolSize）

        //当任务线程数量 大于 核心线程数+阻塞队列之和时 ,
        //      会启动非核心线程与核心线程并发，启动的非核心数量为 (任务数量 - 核心线程 - 阻塞队列)
        nThread t1 = new nThread("t1");
        nThread t2 = new nThread("t2");
        nThread t3 = new nThread("t3");
        nThread t4 = new nThread("t4");
        nThread t5 = new nThread("t5");
        nThread t6 = new nThread("t6");
        nThread t7 = new nThread("t7");
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.submit(t4);
        executor.submit(t5);
        executor.submit(t6);
        executor.submit(t7);

        executor.shutdown();
    }
}
