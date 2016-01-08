package ARDrone.Drone;

import ARDrone.Utility.ATCommand;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ARDrone.Utility
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
    public void sendCommand(ATCommand cmd) {
        //connect to ip
        //put together string
        //send string to ip
        //increment sequenceNumber
    }
}
