package thread;

import javafx.concurrent.Task;

import java.util.concurrent.Callable;

/**
 * Created by st0001 on 2017/3/29.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "of TaskWith Result of "+id;
    }
}
