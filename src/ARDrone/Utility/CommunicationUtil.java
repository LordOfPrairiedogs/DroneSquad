package ARDrone.Utility;

/**
 * ARDrone.Utility
 */
public class CommunicationUtil
{
    private static ATCommand atRefCommand (){
        ATCommand atCmd = new ATCommand(DroneConstants.AT_REF_CMD);
        return atCmd;
    }
}
