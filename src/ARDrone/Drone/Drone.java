package ARDrone.Drone;

import ARDrone.Utility.ATCommand;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ARDrone.Utility
 */
public interface Drone
{
    void setAddress (String address) throws UnknownHostException;
    void sendCommand(ATCommand cmd);
}
