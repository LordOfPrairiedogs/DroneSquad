package Drone.DroneCommands;

/**
 * The Command Interface, this is implemented to produce concrete commands.
 *
 * @author orpheus
 */
public interface ATCommand {
    /**
     * Executes the appropriate code on the ATReceiver. The sequence parameter is
     * so that the invoker can keep track of the command sequence and pass it to
     * individual <ATCommand>'s, as they will need it to create their respective
     * commands.
     *
     * @param sequence
     */
    void execute(int sequence) throws Exception;
}
