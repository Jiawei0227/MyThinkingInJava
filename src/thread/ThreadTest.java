package thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by st0001 on 2017/3/29.
 */
public class ThreadTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<Integer> future = threadPool.submit(()->new Random().nextInt(100));
        try {
            Thread.sleep(5000);// 可能做一些事情
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
