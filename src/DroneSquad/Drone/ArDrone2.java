package DroneSquad.Drone;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DroneSquad.Utility
 * This class represents the drone object, specifically an AR.Drone 2.0 quadcopter. The new drones may have a different
 * spec so they are different implementations.
 *
 * Serves as an interface to the remote object.
 *
 * TODO: Needs a thread for reading drone state messages
 * TODO: Need a way to send messages to physical drone. Takes ATCommand object combines with sequence number and
 * transmits the actual ATCommand string.
 */
public class ArDrone2 implements Drone
{
    private InetAddress inet_addr;
    private int sequenceNumber;

    public ArDrone2 (String address) throws UnknownHostException {
        inet_addr =  InetAddress.getByName(address);
        sequenceNumber = 1;
    }

    @Override
    public void setAddress(String address) throws UnknownHostException {
        inet_addr.getByName(address);
    }

    @Override
    public int getNextSequenceNumber ()
    {
        //Create an ATCommand from message
        return sequenceNumber++;

    }

}
