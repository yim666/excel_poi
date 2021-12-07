package xyz.yh.aop;

import org.springframework.stereotype.Component;

@Component
public interface waiter {

   void greetTo(String name);

    void serverTo(String name);

}
