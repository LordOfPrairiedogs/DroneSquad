package ARDrone.Utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * ARDrone.Utility
 * The idea here is we have a master controller that directs the drone objects. It can switch their modes, clone commands,
 * get flight data, etc.
 */
public class CommandQueue implements Delayed
    {
        private ATCommand data;
        private long startTime;

        public CommandQueue (ATCommand data, long delay)
        {
            this.data = data;
            this.startTime = System.currentTimeMillis () + delay;
        }

        @Override
        public long getDelay (TimeUnit unit)
        {
            long diff = startTime - System.currentTimeMillis ();
            return unit.convert (diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo (Delayed o)
        {
            if (this.startTime < ((CommandQueue) o).startTime)
            {
                return -1;
            }
            if (this.startTime > ((CommandQueue) o).startTime)
            {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString ()
        {
            return "{" +
                    "data='" + data + '\'' +
                    ", startTime=" + startTime +
                    '}';
        }

    class DelayQueueConsumer
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

                        CommandQueue object = (CommandQueue) queue.take ();
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
    }

    class DelayQueueTest {
                /**
                 * @param args
                 */
        public void main(String[] args) {

            // Creates an instance of blocking queue using the DelayQueue.
            BlockingQueue queue = new DelayQueue ();



            // Starting DelayQueue Consumer to take the expired delayed objects from the queue
            new DelayQueueConsumer("Consumer Thread-1", queue).start();

        }

    }

}
