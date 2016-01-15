package DroneSquad.Drone;

import DroneSquad.Utility.ATCommand;

import java.net.UnknownHostException;

/**
 * DroneSquad.Utility
 */
public interface Drone
{
    void setAddress (String address) throws UnknownHostException;
    void sendCommand(ATCommand cmd);
}
