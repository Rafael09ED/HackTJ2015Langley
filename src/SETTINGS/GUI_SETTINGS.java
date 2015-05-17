package SETTINGS;

import java.awt.*;

/**
 * Created by Rafael on 5/16/2015.
 */
public class GUI_SETTINGS {
    public static final Image TRAY_IMAGE;
    public static final String TRAY_NAME = GENERAL_SETTINGS.DISPLAY_NAME;
    static{
        TRAY_IMAGE = Toolkit.getDefaultToolkit().getImage("src/resources/textIcon.png");
    }

}
