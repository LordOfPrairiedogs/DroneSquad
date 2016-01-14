package ARDrone.Utility;

import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ARDrone.Utility
 *
 * https://fivedots.coe.psu.ac.th/~ad/jg2/ch11/GamePadIntro.pdf
 */
public class ManualControl
{
    // global constant
    private static final int DELAY = 40; // ms (polling interval)
    private static final float EPSILON = 0.0001f;
    private static List<Controller> foundControllers;
    private static JoyState joyState;

    //Consider using so we don't waste time polling unnecessary data
    private static void pollComponent(Controller c,
                                      Component component)
    { float prevValue = 0.0f;
        float currValue;
        int i = 1; // used to format the output
        while (true) {
            try {
                Thread.sleep(DELAY); // wait a while
            }
            catch (Exception ex) {}
            c.poll(); // update the controller's components
            currValue = component.getPollData(); // get current value
            if (currValue != prevValue) { // the value has changed
                if (Math.abs(currValue) > EPSILON) {
                    // only show values not near to 0.0f
                    System.out.print(currValue + "; ");
                    i++;
                }
                prevValue = currValue;
            }
            if (i%10 == 0) { // after several outputs, put in a newline
                System.out.println();
                i = 1;
            }
        }
    } // end of pollComponent()

    public static void searchForControllers() {
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

        for(int i = 0; i < controllers.length; i++){
            Controller controller = controllers[i];

            if (
                    controller.getType() == Controller.Type.STICK ||
                            controller.getType() == Controller.Type.GAMEPAD ||
                            controller.getType() == Controller.Type.WHEEL ||
                            controller.getType() == Controller.Type.FINGERSTICK
                    )
            {
                // Add new controller to the list of all controllers.
                if (foundControllers == null) {
                    foundControllers = new ArrayList<>();
                }
                foundControllers.add(controller);
            }
        }
    }

    public static void getJoyData(int selectedControllerIndex) {
        {
            searchForControllers();

            // Currently selected controller.
            Controller controller = foundControllers.get(selectedControllerIndex);

            // Pull controller for current data, and break while loop if controller is disconnected.
            if( !controller.poll() ){
                return;
            }

            // X axis and Y axis
            int xAxisPercentage = 0;
            int yAxisPercentage = 0;

            // Go trough all components of the controller.
            Component[] components = controller.getComponents();
            for(int i=0; i < components.length; i++)
            {
                Component component = components[i];
                Identifier componentIdentifier = component.getIdentifier();

                // Buttons
                //if(component.getName().contains("Button")){ // If the language is not english, this won't work.
                if(componentIdentifier.getName().matches("^[0-9]*$")){ // If the component identifier name contains only numbers, then this is a button.
                    // Is button pressed?
                    boolean isItPressed = true;
                    if(component.getPollData() == 0.0f)
                        isItPressed = false;

                    // Button index
                    String buttonIndex;
                    buttonIndex = component.getIdentifier().toString();

                    // We know that this component was button so we can skip to next component.
                    continue;
                }

                // Hat switch
                if(componentIdentifier == Component.Identifier.Axis.POV){
                    float hatSwitchPosition = component.getPollData();

                    // We know that this component was hat switch so we can skip to next component.
                    continue;
                }

                // Axes
                if(component.isAnalog()){
                    float axisValue = component.getPollData();
                    int axisValueInPercentage = getAxisValueInPercentage(axisValue);

                    // X axis
                    if(componentIdentifier == Component.Identifier.Axis.X){
                        xAxisPercentage = axisValueInPercentage;
                        continue; // Go to next component.
                    }
                    // Y axis
                    if(componentIdentifier == Component.Identifier.Axis.Y){
                        yAxisPercentage = axisValueInPercentage;
                        continue; // Go to next component.
                    }
                }
            }

            // Now that we go trough all controller components,
            // we add butons panel to drone controller,
            CommunicationUtil.createCommand(joyState);

            //window.setControllerButtons(buttonsPanel);
            // set x and y axes,
            //window.setXYAxis(xAxisPercentage, yAxisPercentage);
            // add other axes panel to window.
            //window.addAxisPanel(axesPanel);

            // We have to give processor some rest.
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(ManualControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static int getAxisValueInPercentage(float axisValue)
    {
        return (int)(((2 - (1 - axisValue)) * 100) / 2);
    }

/**********************************************************************************************
This handles the thread that will read controller data and periodically send something to the queue.

 // Starting DelayQueue Producer to push some delayed objects to the queue
 new DelayQueueProducer(queue).start();
 **********************************************************************************************/

public class DelayQueueProducer
{//TODO: The threads for this need to be instantiated elsewhere. This object is the queue only.
    //The thread will be associated with manual control.

    private final Random random = new Random ();
    // Creates an instance of blocking queue using the DelayQueue.
    private BlockingQueue queue;
    private Thread producerThread = new Thread (new Runnable ()
    {
        @Override
        public void run ()
        {
            while (true)
            {
                try
                {
                    // Put some Delayed object into the DelayQueue.
                    int delay = random.nextInt (10000);
                    ATCommand atCmd = new ATCommand ("");
                    CommandQueue object = new CommandQueue (atCmd, delay);

                    System.out.printf ("Put object = %s%n", object);
                    queue.put (object);
                    Thread.sleep (500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace ();
                }
            }
        }
    }, "Producer Thread");

    public DelayQueueProducer (BlockingQueue queue)
    {
        super ();
        this.queue = queue;
    }

    public void start ()
    {
        this.producerThread.start ();
    }
}




}
