package DroneSquad.Utility;

import java.net.InetAddress;
import java.util.List;

/**
 * DroneSquad.Utility
 */
public class AutopilotControl
{
    //This should send similar data to the drone controller but with an added element of duration.
    public static void uploadStaticAutopilot(List autopilotList){

    }

    //Method to store manual flight as autopilot data
    public static void storeManualAsAutopilot (List manualQueue){
        //might be better as a listener
    }

    //Method to set a drone to do formation fly
    public static void doFormation (String pattern, Integer position, InetAddress leaderIP){
        //pattern.follow
        //pattern.V
        //pattern.surround
        //pattern.stack
        //pattern.clone
    }

    private static void reorient (){
        //Tells the drone to get a bearing dependant on pattern
    }


}
