package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Jerry Wang on 2017/3/27.
 */
public class DynamicProxy implements InvocationHandler {

    private Object subject;

    public DynamicProxy(Object subject){
        this.subject = subject;
    }
    /**
     *
     * @param proxy 我们所代理的真是对象
     * @param method 我们要调用真是对象的某个方法的Method对象
     * @param args 调用真是对象某个方法时候的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before rent() method");
        method.invoke(subject,args);
        System.out.println("after rent() method");
        return null;
    }
}
