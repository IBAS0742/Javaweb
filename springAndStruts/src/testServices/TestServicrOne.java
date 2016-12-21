package testServices;

import testDao.TestDaoOne;

/**
 * Created by ibas on 12/14/16.
 */
public class TestServicrOne {
    private TestDaoOne testDaoOne;

    public void setTestDaoOne(TestDaoOne testDaoOne) {
        this.testDaoOne = testDaoOne;
    }

    public void methodOne(){
        testDaoOne.methodOne();
    }
}
