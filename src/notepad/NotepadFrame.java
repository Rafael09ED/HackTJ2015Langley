package notepad;

import SETTINGS.GENERAL_SETTINGS;
import notepad.elements.*;
import notepad.keyTracker.KeyTracker;
import notepad.keyTracker.Keybinds.WindowDrag;
import notepad.textPanel.TextPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rafael on 5/16/2015.
 */
public class NotepadFrame extends JFrame {
    private TextPanel textPanel;
    private NotepadMenuBar notepadMenuBar;
    private KeyTracker keyTracker;
    private WindowDrag windowDrag;
    public NotepadFrame() {

        // JFrame Settings
        setTitle(GENERAL_SETTINGS.DISPLAY_NAME);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        // GUI Contents
        createTextPanel();
        createJMenuBar();

        createKeyTracker();
    }

    private void createKeyTracker() {
        keyTracker = new KeyTracker(this);
        addKeyListener(keyTracker.keyListener);
        textPanel.textField.addKeyListener(keyTracker.keyListener);
        // create CTRL movement;
        windowDrag = new WindowDrag(this);
        textPanel.textField.addMouseListener(windowDrag.mouseMotionAdapter);
        keyTracker.keyBinds.add(windowDrag.getKeyBind());
    }

    private void createJMenuBar(){
        notepadMenuBar = new NotepadMenuBar();

        JMenu jMenu = new JMenu("View");
        notepadMenuBar.add(jMenu);

        add(notepadMenuBar, BorderLayout.NORTH);
    }

    private void createTextPanel() {
        textPanel = new TextPanel();
        add(textPanel, BorderLayout.CENTER);
    }
}
