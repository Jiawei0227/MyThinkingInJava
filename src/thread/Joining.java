package thread;

/**
 * Created by st0001 on 2017/3/29.
 */
public class Joining{
    public static void main(String args[]){
        Sleeper sleeper = new Sleeper("sleepy",1500),
              grumpy = new Sleeper("Grumpy",1500);
        Joiner
                dopey = new Joiner("Dopey",sleeper),
                doc = new Joiner("Doc",grumpy);

        grumpy.interrupt();
    }

}

class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    public void run(){
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName()+" was interrupted. " + "isInterrupted(): "+ isInterrupted());
           // e.printStackTrace();
            return;
        }
        System.out.println(getName()+ " has awakened");
    }

}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run(){
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            //e.printStackTrace();
        }
        System.out.println(getName()+ " join completed");
    }
}
