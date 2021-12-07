package xyz.yh.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yim
 */
@Aspect
@Slf4j
@Component  //必须加，把切面交给ioc容器管理
public class BaseAspect {
    @Around("@annotation(xyz.yh.aop.log.RunTimeLog)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("【触发环绕增强：】....");
        long l = System.currentTimeMillis();
        //通过代理类调用业务逻辑执行
        Object proceed = pjp.proceed();
        log.info("【测试环绕增强：】当前方法{}执行成功,调用者为：{}，此方法运行时间为:{} ms",
                pjp.getSignature().getName(),
                pjp.getTarget().getClass().getName()
                , (System.currentTimeMillis() - l));
        return proceed;
    }
//    异常增强，在业务方法调用是程序出现异常并且异常在没有被捕获的前提下所触发
    @AfterThrowing(value = "@annotation(xyz.yh.aop.log.RunTimeLog)",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e){
        Map params =  AopHelper.getMethodParams(jp);
        log.info("触发异常增强，当前程序抛出异常的方法是:" + jp.getSignature()
                + ", 请求参数为:" + params.toString() + "，异常信息为:" + e.getMessage());
        // TODO 后面可执行入库、入ELK、入mongoDB等等
    }

}

