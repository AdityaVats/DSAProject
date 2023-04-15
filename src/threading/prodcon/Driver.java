package threading.prodcon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Created by libsys on 1/20/2023.
 */
public class Driver {
    public static void main(String[] args){


        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(128);
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
