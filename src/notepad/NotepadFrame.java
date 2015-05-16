package notepad;

import SETTINGS.GENERAL_SETTINGS;
import notepad.textPanel.TextPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rafael on 5/16/2015.
 */
public class NotepadFrame extends JFrame {
    private TextPanel textPanel;
    public NotepadFrame() {

        // JFrame Settings
        setTitle(GENERAL_SETTINGS.DISPLAY_NAME);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setType(Type.NORMAL);
        setSize(500, 500);
        setLayout(new BorderLayout());

        // GUI Contents
        createTextPanel();
    }

    private void createTextPanel() {
        textPanel = new TextPanel();
        add(textPanel, BorderLayout.CENTER);
    }
}
