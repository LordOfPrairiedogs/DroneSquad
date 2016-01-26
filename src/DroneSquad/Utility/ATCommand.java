package DroneSquad.Utility;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DroneSquad.Utility
 * This is the thing that gets stuffed in the queue
 */
public class ATCommand implements Delayed
{
    private long startTime;
    private String atCmd;

    public ATCommand (String cmd, long time)
    {
        atCmd = cmd;
        startTime = time;
        //TODO: Queue it somehow
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
        if (this.startTime < ((ATCommand) o).startTime)
        {
            return -1;
        }
        if (this.startTime > ((ATCommand) o).startTime)
        {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString ()
    {
        return "{" +
                "atCmd='" + atCmd + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
