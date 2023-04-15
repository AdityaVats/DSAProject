package threading.executorservice;

import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 1/12/2023.
 */
public class MyThreadPool {

    List<Thread> threads;

    public MyThreadPool(int n){
        threads = new ArrayList<>();
        for(int i=0;i<n;i++)    threads.add(null);
    }

}
