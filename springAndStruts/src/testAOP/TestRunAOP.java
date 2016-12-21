package testAOP;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ibas on 12/15/16.
 */
public class TestRunAOP {

    ApplicationContext ac = new ClassPathXmlApplicationContext("testAOP/test-AOP.xml");

    //实现了接口的AOP代理
    @Test
    public void testOne() {
        System.out.println("TestRunAOP testOne");
        //TestRunAOP testOne

        ITestClassOne tco = (ITestClassOne) ac.getBean("testClassOne");

        System.out.println(tco.getClass());
        //class com.sun.proxy.$Proxy8   (JDK动代理)

        tco.methodOne();
        //AOPmethod beforeMethod
        //TestClassOne methodOne
        //AOPmethod afterMethod
    }

    //实现了接口的AOP代理
    @Test
    public void testTwo() {
        System.out.println("TestRunAOP testOne");
        //TestRunAOP testOne

        TestClassTwo tco = (TestClassTwo) ac.getBean("testClassTwo");

        System.out.println(tco.getClass());
        //class testAOP.TestClassTwo$$EnhancerByCGLIB$$66038b6d   (cglib动态代理)

        tco.methodOne();
        //AOPmethod beforeMethod
        //TestClassTwo methodOne
        //AOPmethod afterMethod
    }
}
