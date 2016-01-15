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

/*************************************************
 * The process flow
 ************************************************
 *
 * Create a drone
 * Command the drone
 ** Manual
 *** Singleton/Thread
 *** Create keymap poller (only polls the joystick values that are being used)
 *** Read joystick values
 *** Send values to interpreter, then message builder
 *** Sends AtCmd to CommandQueue for stacking
 ** Autopilot
 *** Multi-thread (one thread per IP)
 *** Read stored delayBlockingQueue & interprets with new times, init, delay, etc.
 ** Parrot/Follow/Formation
 *** Multi-thread (one thread per IP)
 *** implements Follows (IP)
 *** mode (parrot, follow, formation(x), etc)
 *
 * Message Builder consumes a _joystickPoll_, _messageString_
 ** returns ATCmd
 *
 * CommandInterpreter
 ** Takes joystick settings (possibly position data?) and disceminates to message builder, autopilot/formation, etc.
 ** Some commands are direct (turn left, gain altitude, move back) some indirect (close formation, change formation, record
 *      autopilot stack, etc.
 *
 * CommandQueue
 ** Somewhere the CommandQueue is started. Probably after first message sent. Needs to be a thread.
 ** Reads ATCmd and puts in queue
 *** Interprets time as delay
 ** Pops the queue and sends to IP
 *** Thread
 *** Mashes several commands to single message if possible
 *** Send to autopilot store if requested
 *
 *TODO: Think about how to manage the following
 * What to do with latentcy
 * How to create controller configurator
 * How to handle missing commands
 * How to implement feedback (such as landing)
 * Test cases
 * Autopilot editor
 *
 *
 *
 *
 *
 *
 * */

    }
}
