package ARDrone;

import ARDrone.Utility.ManualControl;

/**
 * Created by dar on 1/10/16.
 */
public class DroneTest {
    public static void main(String[] args) {
        //need to figure out initialization
        ManualControl.searchForControllers();
        ManualControl.getJoyData(0);

    }
}
