package Lab4.BlockingQuene;

import java.util.concurrent.BlockingQueue;

public class Adder implements Runnable {
    private BlockingQueue<Integer> queue;
    int countToAdd;
    public Adder(BlockingQueue<Integer> queue, int countToAdd){
        this.queue = queue;
        this.countToAdd = countToAdd;
    }

    public void run(){
        try{
            for(int i =1; i<=countToAdd;i++){
                queue.put(i);
                System.out.printf("Added: %d%n",i);
                Thread.sleep(100);
            }
        }catch(InterruptedException ex){
            System.out.println("Adder interrupted");
        }
    }
}
