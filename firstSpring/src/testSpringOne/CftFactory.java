package testSpringOne;

/**
 * Created by ibas on 12/13/16.
 */
public class CftFactory {

    public ClassForTest InvokeOne(){
        return new ClassForTest();
    }

    public static ClassForTest InvokeTwo() {
        return new ClassForTest();
    }

}
