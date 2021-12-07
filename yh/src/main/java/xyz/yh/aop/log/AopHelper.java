package xyz.yh.aop.log;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;


import java.util.HashMap;
import java.util.Map;

public class AopHelper {
    /**
     * 在执行方法前，校验参数是否为空
     */
    public  static Map getMethodParams(JoinPoint joinPoint){
        String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Map params =new HashMap();
        if (ArrayUtils.isEmpty(names)) return params;
        Object[] values = joinPoint.getArgs();
        for (int i = 0; i < names.length; i++) {
            params.put(names[i],values[i]);
        }
        return params;
    }
}
