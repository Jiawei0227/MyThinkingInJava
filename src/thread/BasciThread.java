package thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by st0001 on 2017/3/29.
 */
public class BasciThread {

    public static void main(String args[]){
        BasciThread b = new BasciThread();
        b.test6();
    }

    public void test1(){
        Thread t = new Thread(new LifeOff());
        t.start();
        System.out.println("waiting for it");
    }

    public void test2(){
        for(int i = 0;i<5;i++){
            new Thread(new LifeOff()).start();
        }
        System.out.println("waiting for it ");
    }

    public void test3(){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i< 5 ; i++){
            exec.execute(new LifeOff());
        }
        exec.shutdown();
    }

    public void test4(){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i< 5 ; i++){
            exec.execute(new LifeOff());
        }
        exec.shutdown();
    }

    public void test5(){
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for(int i = 0; i< 5 ; i++){
            exec.execute(new LifeOff());
        }
        exec.shutdown();
    }

    public void test6(){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i = 0 ;i<10 ; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        results.forEach(e->{
            try {
                System.out.println(e.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }finally {
                exec.shutdown();
            }
        });
    }
}
