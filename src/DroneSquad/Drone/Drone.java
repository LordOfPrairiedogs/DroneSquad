package DroneSquad.Drone;

import java.net.UnknownHostException;

/**
 * DroneSquad.Utility
 */
public interface Drone
{
    void setAddress (String address) throws UnknownHostException;

    int getNextSequenceNumber ();
}
