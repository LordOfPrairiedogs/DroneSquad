package DroneSquad.Drone;

import org.junit.Test;

import java.net.UnknownHostException;

/**
 * DroneSquad.Drone
 */
public class ArDrone2Test
{
    //Happy path test case
    @Test
    public void testSetAddress ()
            throws Exception
    {
        //Setup
        ArDrone2 myTestDrone = new ArDrone2 ("192.168.1.1");

        //Exercise


        //Verify


        //Teardown


    }

    //Corner test case
    //TODO: Write corner tests

    //Exception Testing
    @Test ( expected = UnknownHostException.class )
    public void testSetAddressUnknownHostException ()
        throws Exception
    {
        //Setup
        ArDrone2 myTestDrone = new ArDrone2 ("A Cow Says Moo");

        //Exercise

        //Verify

        //Teardown
    }

    @Test
    public void testSendCommand ()
            throws Exception
    {

    }
}