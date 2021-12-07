package xyz.yh.aop;

import org.springframework.stereotype.Component;
import xyz.yh.aop.log.RunTimeLog;

@Component
public class youngWaiter implements waiter{

    @Override
    @RunTimeLog
    public void greetTo(String name) {
        System.out.println("youngWaiter: greet to  "+name);
    }

    @Override
    @RunTimeLog
    public void serverTo(String name) {
        System.out.println("youngWaiter: server to  "+name+9/0);


    }
}

