package DroneSquad.Utility;

import java.net.InetAddress;

/**
 * DroneSquad.Utility
 */
public class ATCommand
{
//    public int sequence; //need to get from crontroller so next in sequence
    private String [] args;
    private String cmd;
    //speed?

    public InetAddress getAddy ()
    {
        return addy;
    }

    public void setAddy (InetAddress addy)
    {
        this.addy = addy;
    }

    public String[] getArgs ()
    {
        return args;
    }

    public void setArgs (String[] args)
    {
        this.args = args;
    }

    public String getCmd ()
    {
        return cmd;
    }

    public void setCmd (String cmd)
    {
        this.cmd = cmd;
    }

    private InetAddress addy;

    public ATCommand (){
    }

    public ATCommand (String commandName){
        cmd = commandName;
    }

    public ATCommand (String commandName, String [] cmdArgs){
        cmd = commandName;
        args = cmdArgs;
    }

    public String toString (){
        return null;
    }

    private boolean isValidMessage () {
        return true;
    }
}
