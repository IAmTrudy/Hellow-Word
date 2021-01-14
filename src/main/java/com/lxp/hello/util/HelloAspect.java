package com.lxp.hello.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class HelloAspect {//这个是切面

    @Pointcut("execution(public * com.lxp.hello.sys.controller.*.find*(..))")
    public void pointCut(){//切点
    }

    @Before("pointCut()")
    public void before(){//before
        //增强
        System.out.println("before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after");
    }
}
