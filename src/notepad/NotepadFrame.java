package notepad;

import SETTINGS.GENERAL_SETTINGS;
import notepad.elements.NotepadMenuBar;
import notepad.keyTracker.KeyTracker;
import notepad.textPanel.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Rafael on 5/16/2015.
 */
public class NotepadFrame extends JFrame {
    private TextPanel textPanel;
    private NotepadMenuBar notepadMenuBar;
    private KeyTracker keyTracker;
    private MouseListener windowDrag;

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
        windowDrag = new MouseAdapter() {
            Point mousePointOnScreen;

            @Override
            public void mousePressed(MouseEvent e) {
                mousePointOnScreen = e.getLocationOnScreen();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.isControlDown()) {
                    System.out.println("Dragged");
                    Point p = NotepadFrame.this.getLocation();
                    p.x += e.getXOnScreen() - mousePointOnScreen.x;
                    p.y += e.getYOnScreen() - mousePointOnScreen.y;
                    NotepadFrame.this.setLocation(p);
                    mousePointOnScreen = e.getLocationOnScreen();
                }
            }
        };
        textPanel.textField.addMouseListener(windowDrag);
    }

    private void createJMenuBar() {
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
