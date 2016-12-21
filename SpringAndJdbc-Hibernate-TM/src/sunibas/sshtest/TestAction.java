package sunibas.sshtest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * Created by ibas on 12/21/16.
 */
public class TestAction extends ActionSupport {

    private TestService testService;

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public String one(){
        System.out.println("testaction one");
        TestEntity testEntity = new TestEntity();
        testEntity.setCol2((new Date()).toString());
        testService.save(testEntity);
        return SUCCESS;
    }
}
