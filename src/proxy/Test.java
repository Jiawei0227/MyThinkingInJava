package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Jerry Wang on 2017/3/25.
 */
public class Test {

    public static void main(String args[]){
        Subject realSubject = new ReadSubject();
        InvocationHandler handler = new DynamicProxy(realSubject);

        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),handler);

        subject.rent();
        subject.hello("hh");
    }
}
