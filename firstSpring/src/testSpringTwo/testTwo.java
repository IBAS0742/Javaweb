package testSpringTwo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testTool.toolOne;

import javax.annotation.Resource;

/**
 * Created by ibas on 12/13/16.
 * applicationContext0.xml   scope="prototype"
 * applicationContext1.xml  scope="singleton"
 * applicationContext2.xml  scope="singleton" lazy-init="true"
 * applicationContext3.xml  带参数初始化
 * applicationContext4.xml  工厂创建
 * applicationContext5.xml  set注入
 * applicationContext6.xml  内部bean
 * applicationContext7.xml  p命名空间
 */

public class testTwo {

    toolOne to = new toolOne(1);


    //using @Component("cft")
    @Test
    public void testO(){
        to.commonTest("testSpringTwo/applicationContext0.xml","ocft");

        /*
        ClassForTest creating.
        before using.
        { id = 0 , { id = 0 , record = record , time = 1481695967192} }
        * */
    }

    //using @Component
    @Test
    public void testT(){
        to.commonTest("testSpringTwo/applicationContext0.xml","overCFT");

        /*
        ClassForTest creating.
        before using.
        { id = 0 , { id = 0 , record = record , time = 1481697453332} }
        * */
    }
}
