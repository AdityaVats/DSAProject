package threading;

import threading.prodcon.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by libsys on 10/14/2022.
 */
public class MainDriver {


    public static void mainForExecutorService(String[] args){
        ExecutorService executorService = new ThreadPoolExecutor(
                10,20,1000L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(128)
        );

        RejectedExecutionHandler re = (runnable, executor) -> {
            try {
                executor.getQueue().put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for(int i=0;i<100;i++)   executorService.execute(() -> System.out.println(Thread.currentThread().getId() + " Task"));
      // executorService.execute();

        Callable<String> callable = () ->  "My Result is this";
        Future<String> future = executorService.submit(callable);
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("CANCELLED TASK"+executorService.shutdownNow().size());
        try{
            executorService.awaitTermination(10000L,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
