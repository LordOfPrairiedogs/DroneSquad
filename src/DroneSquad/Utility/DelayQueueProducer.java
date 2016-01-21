package DroneSquad.Utility;

/**
 * DroneSquad.Utility
 */

import java.util.concurrent.BlockingQueue;

/**********************************************************************************************
 * This handles the thread that will read controller data and periodically send something to the queue.
 * <p/>
 * // Starting DelayQueue Producer to push some delayed objects to the queue
 * new DelayQueueProducer(queue).start();
 **********************************************************************************************/

public class DelayQueueProducer
{
    //The thread will be associated with manual control.
    // Creates an instance of blocking queue using the DelayQueue.
    private BlockingQueue queue;
    private Thread producerThread = new Thread (new Runnable ()
    {
        @Override
        public void run ()
        {
            while (true)
            {
                try
                {
                    // Put some Delayed object into the DelayQueue.
                    ATCommand atCmd = new ATCommand ("");
                    QueueCommand object = new QueueCommand (atCmd, 1);

                    System.out.printf ("Put object = %s%n", object);
                    queue.put (object);
                    Thread.sleep (500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace ();
                }
            }
        }
    }, "Producer Thread");

    public DelayQueueProducer (BlockingQueue queue)
    {
        super ();
        this.queue = queue;
    }

    public void start ()
    {
        this.producerThread.start ();
    }
}