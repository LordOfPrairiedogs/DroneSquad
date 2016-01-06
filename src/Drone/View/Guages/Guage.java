package Drone.View.Guages;

import javax.swing.*;
import java.awt.*;

/**
 * @author orpheus
 */
public class Guage extends JPanel {
    /**  **/
    private static final long serialVersionUID = 4723637445052589432L;
    /**  **/
    public static String defaultValue = "NULL";
    /**  **/
    JLabel data;

    /**
     *
     */
    public Guage() {
        data = new JLabel(defaultValue + " (Meters)");
        data.setForeground(new Color(254, 254, 254));
        this.add(data);
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder("Altitude"));
        this.setSize(110, 110);
        this.setBackground(new Color(0, 0, 0));
    }

    /**
     * @param altitude
     */
    public void update(Float value) {
        data.setText(value.toString() + " Meters");
    }
}
