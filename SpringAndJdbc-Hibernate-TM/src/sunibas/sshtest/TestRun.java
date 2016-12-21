package sunibas.sshtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by ibas on 12/20/16.
 */
public class TestRun {


    @Test
    public void testOne(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        TestAction testAction = (TestAction) ac.getBean("testAction");
        System.out.println(testAction);
    }
}
