package Lab4.BlockingQuene;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread adderThread = new Thread(new Adder(queue,100));
        Thread averagerThread = new Thread(new Averager(queue,4));
        adderThread.start();
        averagerThread.start();
        Thread.sleep(20000);
        adderThread.interrupt();
        averagerThread.interrupt();

    }
}
