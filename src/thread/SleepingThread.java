package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by st0001 on 2017/3/29.
 */
public class SleepingThread extends LifeOff{


    public void run(){
        while(countDown-- > 0){
            System.out.print(status());

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String args[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0 ;i<10 ;i++){
            exec.execute(new SleepingThread());
        }
        exec.shutdown();
    }

}
