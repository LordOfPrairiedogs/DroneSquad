package ARDrone.Utility;

/**
 * ARDrone.Utility
 * Turns raw data into communication messages, uses communication data to get drone data.
 */
public class CommunicationUtil
{
    //Converts a joystate to a command
    //may be depricated in favor of a method that just takes a class of commands.
    public static ATCommand createCommand(JoyState joyState){
        ATCommand atCmd = new ATCommand(DroneConstants.AT_REF_CMD);
        return atCmd;
    }

    public static ATCommand atRefCommand (){
        ATCommand atCmd = new ATCommand(DroneConstants.AT_REF_CMD);
        return atCmd;
    }
}
