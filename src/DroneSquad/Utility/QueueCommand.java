package DroneSquad.Utility;

import java.util.concurrent.BlockingQueue;

/**
 * DroneSquad.Utility
 */
public class QueueCommand
{
    private ATCommand data;
    private long startTime;
    private BlockingQueue blockingQueue;

    public QueueCommand (BlockingQueue queue)
    {
        super ();
        this.blockingQueue = queue;
    }

}
