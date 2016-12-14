package testSpringOne;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import testTool.toolOne;

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

public class testOne {

    toolOne tool = new toolOne("cft",2);

    @Test
    public void testO(){
        Resource resource = new ClassPathResource("testSpringOne/applicationContext0.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        System.out.println("before using.");

        ClassForTest cft = (ClassForTest)factory.getBean("cft");
        ClassForTest cft1 = (ClassForTest)factory.getBean("cft");
        System.out.println(cft);
        System.out.println(cft1);

        /**
         before using.
         ClassForTest creating.
         ClassForTest creating.
         { id = 0 , record = record , time = 1481636183605}
         { id = 0 , record = record , time = 1481636183622}
         * */
    }

    @Test
    public void testT(){
        //? scope="singleton" 在这里失效 ?
        Resource resource = new ClassPathResource("testSpringOne/applicationContext1.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        System.out.println("before using.");

        ClassForTest cft = (ClassForTest)factory.getBean("cft");
        ClassForTest cft1 = (ClassForTest)factory.getBean("cft");
        System.out.println(cft);
        System.out.println(cft1);
        /**
         before using.
         ClassForTest creating.
         { id = 0 , record = record , time = 1481636200678}
         { id = 0 , record = record , time = 1481636200678}
         * */
     }

    @Test
    public void testTh() {
        tool.commonTest("testSpringOne/applicationContext0.xml");

        /**
         before using.
         ClassForTest creating.
         ClassForTest creating.
         { id = 0 , record = record , time = 1481636217386}
         { id = 0 , record = record , time = 1481636217422}
         * */
    }

    @Test
    public void testF() {
        tool.commonTest("testSpringOne/applicationContext1.xml");

        /**
         ClassForTest creating.
         before using.
         { id = 0 , record = record , time = 1481636228639}
         { id = 0 , record = record , time = 1481636228639}
         * */
    }

    @Test
    public void testFi() {
        tool.commonTest("testSpringOne/applicationContext2.xml");

        /**
         ###lazy-init="false"
         ClassForTest creating.
         before using.
         { id = 0 , record = record , time = 1481636509910}
         { id = 0 , record = record , time = 1481636509910}
         ############################################################
         ###lazy-init="true"
         ClassForTest creating.
         { id = 0 , record = record , time = 1481636528570}
         { id = 0 , record = record , time = 1481636528570}
         * */
    }

    @Test
    public void testS() {
        tool.commonTest("testSpringOne/applicationContext3.xml");

        /**
         ClassForTest creating.
         before using.
         { id = 0 , record = recordArg , time = 1481639243501}
         { id = 0 , record = recordArg , time = 1481639243501}
         * */

        tool.commonTest("testSpringOne/applicationContext3.xml", "cft_1");

        /**
         ClassForTest creating.
         ClassForTest creating.
         before using.
         { id = 0 , record = argOne__ , time = 1481640081878}
         { id = 0 , record = argOne__ , time = 1481640081878}
         * */
     }

    @Test
    public void testSe() {
        tool.commonTest("testSpringOne/applicationContext4.xml", "ctfOne");

        /**
         ClassForTest creating.
         ClassForTest creating.
         before using.
         { id = 0 , record = record , time = 1481639849578}
         { id = 0 , record = record , time = 1481639849578}
         * */

        tool.commonTest("testSpringOne/applicationContext4.xml", "cftTwo");

        /**
         ClassForTest creating.
         ClassForTest creating.
         before using.
         { id = 0 , record = record , time = 1481639906793}
         { id = 0 , record = record , time = 1481639906793}
         * */
    }

    @Test
    public void testE() {
        tool.commonTest("testSpringOne/applicationContext5.xml");

        /**
         ClassForTest creating.
         before using.
         { id = 0 , record = record_ref , time = 1481641481678}
         { id = 0 , record = record_ref , time = 1481641481678}
         * */
    }

    @Test
    public void testN() {
        tool.commonTest("testSpringOne/applicationContext6.xml", "ocft");

        /**
         ClassForTest creating.
         before using.
         { id = 0 , { id = 0 , record = record , time = 1481642165175} }
         { id = 0 , { id = 0 , record = record , time = 1481642165175} }
         * */

        tool.commonTest("testSpringOne/applicationContext6.xml", "ocft1");
        /**
         ClassForTest creating.
         ClassForTest creating.
         before using.
         { id = 0 , { id = 0 , record = record , time = 1481642252203} }
         { id = 0 , { id = 0 , record = record , time = 1481642252203} }
         * */
    }

    @Test
    public void testTe() {
        tool.commonTest("testSpringOne/applicationContext6.xml", "cft");
        /**
         ClassForTest creating.
         ClassForTest creating.
         before using.
         { id = 0 , record = record , time = 1481642915378}
         { id = 0 , record = record , time = 1481642915378}
         * */

        tool.commonTest("testSpringOne/applicationContext6.xml", "ocft");
        /**
         ClassForTest creating.
         ClassForTest creating.
         before using.
         { id = 0 , { id = 0 , record = record , time = 1481642982375} }
         { id = 0 , { id = 0 , record = record , time = 1481642982375} }
         */
     }

    @Test
    public void testEl() {
        tool.commonTest("testSpringOne/applicationContext8.xml", "ocft");

        /**
         ClassForTest creating.
         before using.
         { id = 0 , { id = 0 , record = p namespace record , time = 1481643809840} }
         { id = 0 , { id = 0 , record = p namespace record , time = 1481643809840} }
         * */

        tool.commonTest("testSpringOne/applicationContext8.xml", "ocft");

        /**
         ClassForTest creating.
         before using.
         { id = 0 , { id = 0 , record = p namespace record , time = 1481643809996} }
         { id = 0 , { id = 0 , record = p namespace record , time = 1481643809996} }
         * */
     }
}
