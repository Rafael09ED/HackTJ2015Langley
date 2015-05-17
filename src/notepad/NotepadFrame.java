package notepad;

import SETTINGS.GENERAL_SETTINGS;
import notepad.elements.NotepadMenuBar;
import notepad.transparency.TransparencyManager;
import notepad.keyTracker.KeyTracker;
import notepad.keyTracker.Keybinds.WindowDrag;
import notepad.textPanel.HTMLEditorPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Rafael on 5/16/2015.
 */
public class NotepadFrame extends JFrame {
    public HTMLEditorPanel textPanel;
    private NotepadMenuBar notepadMenuBar;
    private KeyTracker keyTracker;
    
    private WindowDrag windowDrag;
    public final TransparencyManager transparencyManager;

    public NotepadFrame() {
        // JFrame Settings
        setTitle(GENERAL_SETTINGS.DISPLAY_NAME);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(500, 500);
        setUndecorated(true); //set false to put back header
        setLayout(new BorderLayout());

        //GUI Tools
        transparencyManager = new TransparencyManager(this);

        // GUI Contents
        createTextPanel();
        createJMenuBar();
        setBackground(new Color(40, 40, 150, 230));
        createActionTracking();
    }


    private void createActionTracking() {
        keyTracker = new KeyTracker(this);
        addKeyListener(keyTracker.keyListener);
        textPanel.textPane.addKeyListener(keyTracker.keyListener);

        // create CTRL movement;
        windowDrag = new WindowDrag(this);
        windowDrag.addToCtrlDrag(textPanel.textPane);
        windowDrag.addToRegularDrag(notepadMenuBar);

        //menu transparency
        notepadMenuBar.addMouseListener(mouseTransparencyFull);
        notepadMenuBar.setElementsMouseListener(mouseTransparencyFull);
        textPanel.textPane.addMouseListener(mouseTransparencyHighLow);
    }

    private void createJMenuBar() {
        notepadMenuBar = new NotepadMenuBar(this);
        add(notepadMenuBar, BorderLayout.NORTH);
    }


    private void createTextPanel() {
        textPanel = new HTMLEditorPanel(); //testing
        add(textPanel, BorderLayout.CENTER);
    }

    private MouseAdapter mouseTransparencyFull = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            transparencyManager.setOpacity(1f);
        }
    };
    private MouseAdapter mouseTransparencyHighLow = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            transparencyManager.setToHighOpacity();
        }

        public void mouseExited(MouseEvent e) {
            transparencyManager.setToLowOpacity();
        }
    };
}
