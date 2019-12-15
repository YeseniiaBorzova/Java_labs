package Lab4.BlockingQuene;

import java.util.concurrent.BlockingQueue;

public class Averager implements Runnable {
    private BlockingQueue<Integer> queue;
    int countToTake;
    double sum=0;
    int num = 0;

    public Averager(BlockingQueue<Integer> queue, int countToTake){
        this.queue = queue;
        this.countToTake = countToTake;
    }

    public void run(){
        try{
            for(int i = 1; i<=countToTake;i++){
                sum+=queue.take();
                num++;
                System.out.println("Average: "+ sum/num);
            }
        }catch(InterruptedException ex){
            System.out.println("Averager Interrupted");
        }
    }
}
