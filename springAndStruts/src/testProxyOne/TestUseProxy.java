package testProxyOne;

import org.junit.Test;

/**
 * Created by ibas on 12/14/16.
 */
public class TestUseProxy {
    @Test
    public void testOne() {
        //ITestClass itc = new TestClass();
        ITestClass itc_ = (ITestClass) new TestProxy(new TestClass()).getProxyInstance();

        itc_.methodOne();

    }
}
