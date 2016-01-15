package DroneSquad.Drone;

import DroneSquad.Utility.ATCommand;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DroneSquad.Utility
 * This class represents the drone object, specifically an AR.Drone 2.0 quadcopter. The new drones may have a different
 * spec so they are different implementations.
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
        cmd.setAddy (inet_addr);


        //send string to commandQue
        //command queue handles all requests so autopilot features - fleet commands, etc - are handled in one place.
    }

}
