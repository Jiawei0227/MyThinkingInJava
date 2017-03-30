package proxy;

/**
 * Created by Jerry Wang on 2017/3/27.
 */
public class ReadSubject implements Subject{


    @Override
    public void rent() {
        System.out.println("hahaha");
    }

    @Override
    public void hello(String str) {
        System.out.println("My name is"+str);
    }
}
