package DroneSquad.Utility;

import java.util.Map;

/**
 * DroneSquad.Utility
 */
public class JoyState
{
    //I envision this filled with keys and the drone function assigned to it
    private static Map<String, String> keyMap; //keyname function.constant

    //This will be the drone function and the value assigned to it. Float because it could be analog
    private static Map<String, Float> funtMap; //function.constant value

    //Some values can be mashed together in the same command (I think)
    //TODO: See how it is done
    private static float movementDataX;
    private static float movementDataY;
    private static float movementDataZ;

    //Sample value to be stuffed in map, more to follow
    public static final String FUNCT_LAND = "funct.land";

    //Will mash with current if necessary
    public static void setValue (String key, Float value){

    }
}
