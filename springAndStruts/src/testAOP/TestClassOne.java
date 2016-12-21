package testAOP;

import org.springframework.stereotype.Component;

/**
 * Created by ibas on 12/15/16.
 */
@Component
public class TestClassOne implements ITestClassOne {
    @Override
    public void methodOne() {
        System.out.println("TestClassOne methodOne");
    }
}
