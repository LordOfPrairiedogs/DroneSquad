package ARDrone.Utility;

/**
 * ARDrone.Utility
 */
public class ATCommand
{
//    public int sequence; //need to get from crontroller so next in sequence
    public String [] args;
    public String cmd;

    public ATCommand (){
    }

    public ATCommand (String commandName){
        cmd = commandName;
    }

    public ATCommand (String commandName, String [] cmdArgs){
        cmd = commandName;
        args = cmdArgs;
    }

    public String toString (){
        return null;
    }

    public String getNext (){
        // connect to controller or something to get the next available sequence - will be on drone
        return null;
    }
}
