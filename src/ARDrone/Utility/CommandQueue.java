package ARDrone.Utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * ARDrone.Utility
 * The idea here is we have a master controller that directs the drone objects. It can switch their modes, clone commands,
 * get flight data, etc.
 */
public class CommandQueue
{
    //Keeps track of drones and commands.
    private Map<Integer, ATCommand> timeCmdMap = new HashMap<>();

    private static CommandQueue cq=null;
    private CommandQueue ()
    {
        //Private constructor to make sure there is only one queue
    }

    public static CommandQueue instantiate() {
        if (cq == null)
        {
            cq = new CommandQueue ();
        }

        return cq;
    }

    //immediate processing
    public boolean addToQueue (ATCommand cmd) {
        return addToQueue (0, cmd);
    }


    public boolean addToQueue (int timeInMilliSec, ATCommand cmdList){
        return true;
    }

    //TODO: Create a class to handle new _cmd_ issued to _address_ at _time_.
    //no difference between autopilot and regular command except time=SOONEST/NOW
    //
    public class DelayObject implements Delayed
{
        private String data;
        private long startTime;

        public DelayObject(String data, long delay) {
            this.data = data;
            this.startTime = System.currentTimeMillis() + delay;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = startTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.startTime < ((DelayObject) o).startTime) {
                return -1;
            }
            if (this.startTime > ((DelayObject) o).startTime) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "{" +
            "data='" + data + '\'' +
            ", startTime=" + startTime +
            '}';
        }
    }

}
