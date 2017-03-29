package thread;

/**
 * Created by st0001 on 2017/3/29.
 */
public class LifeOff implements Runnable {

    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LifeOff(){}

    public LifeOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"("+(countDown>0 ? countDown:"Life Off")+")";
    }

    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
