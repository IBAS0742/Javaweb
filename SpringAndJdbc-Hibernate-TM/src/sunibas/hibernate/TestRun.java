package sunibas.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by ibas on 12/20/16.
 */
public class TestRun {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void testOne(){
        TestService testService = (TestService) ac.getBean("testService");
        TestEntity testEntity = new TestEntity();
        testEntity.setCol2(new Date().toString());
        testService.save(testEntity);
    }
}
