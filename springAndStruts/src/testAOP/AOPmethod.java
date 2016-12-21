package testAOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by ibas on 12/15/16.
 */
@Aspect
@Component
public class AOPmethod {
    @Pointcut("execution(* testAOP.*.*(..))")                                               //<4>
    public static void methodIn(){}

    //@Before("execution(* testAOP.TestClassOne.*(..))")                                    //<1>
    //@Before("execution(* testAOP.*.*(..))")                                               //<2>
    @Before("methodIn()")                                                                   //<3>配合<4>使用
    public static void beforeMethod(){
        System.out.println("AOPmethod beforeMethod");
    }

    //@After("execution(* testAOP.TestClassOne.*(..))")                                     //<1>
    //@After("execution(* testAOP.*.*(..))")                                                //<2>
    @After("methodIn()")                                                                    //<3>配合<4>使用
    public static void afterMethod() {
        System.out.println("AOPmethod afterMethod");
    }
}
