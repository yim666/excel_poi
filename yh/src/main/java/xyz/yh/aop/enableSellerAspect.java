package xyz.yh.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class enableSellerAspect {
    @Pointcut("execution(* xyz.yh.aop..*(..))")
    public void a(){
    }
    @Before("a()")
    public void beforeAdvice(){
        System.out.println("before....");
    }

    @Around("a()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Around-before");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("Around-after");
    }

}
