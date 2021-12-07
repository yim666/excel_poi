package xyz.yh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import xyz.yh.aop.youngWaiter;

@SpringBootApplication
public class YhApplication {
    public static void main(String[] args) {
        // 通过Java配置来实例化Spring容器
        ConfigurableApplicationContext context = SpringApplication.run(YhApplication.class, args);

        // 在Spring容器中获取Bean对象
        youngWaiter yw= (youngWaiter) context.getBean("youngWaiter");
//        youngWaiter yw=  context.getBean(youngWaiter.class);

        yw.greetTo("yh");
        yw.serverTo("aaa");

    }

}
