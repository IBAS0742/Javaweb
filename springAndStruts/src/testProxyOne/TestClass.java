package testProxyOne;

/**
 * Created by ibas on 12/14/16.
 */
public class TestClass implements ITestClass{

    public void methodBefore(){
        System.out.println("before");
    }

    @Override
    public void methodOne() {
        System.out.println("implements");
    }
}
