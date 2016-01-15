package DroneSquad;

import DroneSquad.Drone.ArDrone2;

import java.net.UnknownHostException;

/**
 * Created by dar on 1/10/16.
 */
public class EndToEndTest
{
    public static void main(String[] args) {
        //TODO: need to figure out initialization
        ArDrone2 primaryDrone = null;
        try
        {
            primaryDrone = new ArDrone2 ("192.168.1.1");
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace ();
        }



    }
}
