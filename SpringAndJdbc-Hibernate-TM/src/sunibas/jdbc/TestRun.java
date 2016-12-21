package sunibas.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by ibas on 12/19/16.
 */
public class TestRun {
    ApplicationContext ac = new ClassPathXmlApplicationContext("sunibas/jdbc/bean.xml");

    @Test
    public void testOne() {
        TestFirst testFirst = (TestFirst) ac.getBean("testFirst");
        testFirst.save();
    }
}
