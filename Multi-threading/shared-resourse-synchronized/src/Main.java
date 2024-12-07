//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.LinkedList;
import java.util.Queue;

class SharedResource{

    private Queue<Integer> queue;
    private int bufferSize;

    public SharedResource(int bufferSize){
        this.bufferSize = bufferSize;
        queue = new LinkedList<>();
    }

    public synchronized  void produce(int data) throws InterruptedException {
        while(queue.size()==bufferSize){
            System.out.println("Produce: Buffer is full");
            wait(); // Releases monitor lock and waits
        }
        queue.add(data);
        System.out.println("Produced item: "+data+" "+Thread.currentThread().getName());

        notify();// Notifies a waiting thread
    }

    public synchronized  void consume() throws InterruptedException {
        while(queue.isEmpty()){
            System.out.println("Consume: Buffer is empty");
            wait();
        }
        int data = queue.poll();
        System.out.println("Consume item: "+data+" "+Thread.currentThread().getName());
        notify();

    }

}
public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(3);

        Thread produceThread = new Thread(()->{
            for(int  i = 0;i<10;i++){
                try {
                    sharedResource.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumeThread = new Thread(()->{
            for(int  i = 0;i<10;i++){
                try {
                    sharedResource.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });



        produceThread.start();
        consumeThread.start();

    }
}



