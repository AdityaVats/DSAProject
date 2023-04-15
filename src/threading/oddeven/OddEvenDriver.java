package threading.oddeven;

/**
 * Created by libsys on 1/10/2023.
 */
public class OddEvenDriver {
    public static void main(String[] args){

        Object[] monitor = new Object[]{new Integer(1)};
        Thread thread1 = new Thread(new Odd(monitor));
        Thread thread2 = new Thread(new Even(monitor));

        thread1.start();
        thread2.start();
    }


}

class Even implements Runnable{
    Object[]  monitor;
    public Even(Object[] monitor){
        this.monitor = monitor;
    }
    public void run(){
        try{
            while((Integer)monitor[0]<=10){

                synchronized (monitor){
                    /**  as long as i am odd  ===> i am going to wait    **/
                    while((Integer)monitor[0]%2 != 0){
                        monitor.wait();

                    }
                    /**  i am odd and i print myself and update the counter**/

                    System.out.println(Thread.currentThread().getName() + " " + (Integer)monitor[0]);
                    monitor[0]  = (Integer)monitor[0] + 1 ;

                    /**  My work is done let other do there work**/

                    monitor.notify();
                }
            }

        } catch(InterruptedException e){

        }
    }
}
class Odd implements Runnable{
    Object[] monitor;
    public Odd(Object[] monitor){
        this.monitor = monitor;
    }

    public void run(){

        try{
            while((Integer)monitor[0]<10){
                synchronized (monitor){
                    /**  as long as i am even  ===> i am going to wait    **/
                    while((Integer)monitor[0]%2 == 0){
                        monitor.wait();

                    }
                    /**  i am odd ==> and i print myself and update the counter**/
                    System.out.println(Thread.currentThread().getName() + " " + (Integer)monitor[0]);
                    monitor[0]  = (Integer)monitor[0] + 1 ;

                    /**  My work is done let other do there work**/
                    monitor.notify();


                }
            }

        } catch(InterruptedException e){

        }

    }
}

