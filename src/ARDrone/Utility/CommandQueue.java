package ARDrone.Utility;

import java.util.List;

/**
 * ARDrone.Utility
 * The idea here is we have a master controller that directs the drone objects. It can switch their modes, clone commands,
 * get flight data, etc.
 */
public class CommandQueue
{
    public boolean addToQueue (ATCommand cmd) {
        //adds a command to the queue
        return true;
    }

    public boolean addToAutopilotQueue (List<ATCommand> cmdList){
        return true;
    }
}
