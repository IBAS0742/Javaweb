package testProxyOne;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * Created by ibas on 12/14/16.
 */
public class TestProxy {
    private Object tar;

    public TestProxy(Object  tar) {
        this.tar = tar;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object o = method.invoke(tar,args);
                        return o;
                    }
                }
        );
    }

    public Object getProxyInstance1() {
        return Proxy.newProxyInstance(
                tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                new impInvocationHandler()
        );
    }

    public class impInvocationHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object o = method.invoke(tar,args);
            return o;
        }
    }
}
