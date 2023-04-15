package threading.prodcon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by libsys on 1/20/2023.
 */
public class Producer implements Runnable{

    BlockingQueue<Integer> blockingQueue;

    Producer(BlockingQueue blockingQueue)   {
        this.blockingQueue = blockingQueue;
    }
    public void run(){
        try{
           while (true) {
               int i = (ThreadLocalRandom.current().nextInt(0,100));
               System.out.println("Producer " + Thread.currentThread().getId() + " producing " + i);
               blockingQueue.put(i);
               Thread.sleep(ThreadLocalRandom.current().nextInt(1000,4000));
           }
        } catch(InterruptedException e){
            System.out.println("GOT interrrupted");
        }


    }


}
class Consumer implements  Runnable{
    BlockingQueue<Integer> blockingQueue;

    Consumer(BlockingQueue blockingQueue)   {
        this.blockingQueue = blockingQueue;
    }
    public void run(){
        try{
            while(true){
                System.out.println( "                               Consumer "+Thread.currentThread().getId() + " consuming "+blockingQueue.take() );
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,4000));
            }
        } catch(InterruptedException e){
            System.out.println("GOT interrrupted");
        }


    }
}
