package testAction;

import com.opensymphony.xwork2.ActionSupport;
import testServices.TestServicrOne;

/**
 * Created by ibas on 12/14/16.
 */
public class TestActionOne extends ActionSupport{
    private TestServicrOne testServicrOne;

    public void setTestServicrOne(TestServicrOne testServicrOne) {
        this.testServicrOne = testServicrOne;
    }

    public String execute() {
        testServicrOne.methodOne();
        return SUCCESS;
    }

}
