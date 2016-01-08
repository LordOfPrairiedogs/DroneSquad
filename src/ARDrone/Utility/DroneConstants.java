package ARDrone.Utility;

/**
 * ARDrone.Utility
 */
public class DroneConstants
{
    public static final String AT_REF_CMD = "AT*REF=";
//    Control Bits
//    Modes
//      The following are AR.Drone modes:
//       Normal mode- flying or waiting on the ground;
//       Emergency mode- AR.Drone engines are cut off;
//    The control input contains from the following bits:
//       Bit 0-7: are not used. Set to 0;
//       Bit 8: Change emergency mode bit.
//       Set the value to 1 to change the mode.
//       If the drone is at normal mode, its mode will be changed to emergency mode in order to stop the engines immediately.
//       If the drone is at emergency mode, its mode will be changed to normal mode to allow the drone to take off again.
//       Set the value to 0 to stay at the same mode or after sending the emergency signals that have been verified and executed by the AR.Drone.
//           Bit 9: take off or land.
//       Set the value to 1 to start the take-off operations to the 1-meter-hight-hovering state.
//       Keep sending this command until the state of AR.Drone will show that it actually took off.
//       Set the value to 0 to make the drone land.
//       This command should be repeated until the drone state in the navdata shows that drone actually landed.
//           Bit 10-17: are not used. Set to 0;
//       Bit 18: not used. Set to 1;
//       Bit 19: not used. Set to 0;
//       Bit 20: not used. Set to 1;
//       Bit 21: not used. set to 0;
//       Bit 22: not used. set to 1;
//       Bit 23: not used. set to 0;
//       Bit 24: not used. set to 1;
//       Bit 25-27: not used. set to 0;
//       Bit 28: not used. set to 1;
//       Bit 29-31: not used. set to 0;
}
