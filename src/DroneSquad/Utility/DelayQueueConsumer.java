package DroneSquad.Utility;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * DroneSquad.Utility
 */
public class DelayQueueConsumer
{
    private String name;
    private BlockingQueue queue;
    private Thread consumerThread = new Thread (new Runnable ()
    {
        @Override
        public void run ()
        {
            while (true)
            {
                try
                {
                    // Take elements out from the DelayQueue object.

                    QueueCommand object = (QueueCommand) queue.take ();
                    System.out.printf ("[%s] - Take object = %s%n", Thread.currentThread ().getName (), object);
                    Thread.sleep (1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace ();
                }
            }
        }
    });

    public DelayQueueConsumer (String name, BlockingQueue queue)
    {
        super ();
        this.name = name;
        this.queue = queue;
    }

    public void start ()
    {
        this.consumerThread.setName (name);
        this.consumerThread.start ();
    }

    class DelayQueueTest
    {
        /**
         * @param args
         */
        public void main (String[] args)
        {

            // Creates an instance of blocking queue using the DelayQueue.
            BlockingQueue queue = new DelayQueue ();


            // Starting DelayQueue Consumer to take the expired delayed objects from the queue
            new DelayQueueConsumer ("Consumer Thread-1", queue).start ();

        }
    }
}
