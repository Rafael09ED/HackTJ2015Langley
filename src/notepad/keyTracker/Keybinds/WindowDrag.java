package notepad.keyTracker.Keybinds;

import notepad.NotepadFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Rafael on 5/17/2015.
 */
public class WindowDrag {
    private NotepadFrame notepadFrame;

    public WindowDrag(NotepadFrame notepadFrame) {
        this.notepadFrame = notepadFrame;
    }

    public void addToCtrlDrag(JComponent jComponent) {
        jComponent.addMouseListener(ctrlDrag);
        jComponent.addMouseMotionListener(ctrlDrag);
    }
    public void addToRegularDrag(JComponent jComponent) {
        jComponent.addMouseListener(justDrag);
        jComponent.addMouseMotionListener(justDrag);
    }
    private MouseAdapter ctrlDrag = new MouseAdapter() {
        Point mousePointOnScreen;

        @Override
        public void mousePressed(MouseEvent e) {
            mousePointOnScreen = e.getLocationOnScreen();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (e.isControlDown()) {
                Point p = notepadFrame.getLocation();
                p.x += e.getXOnScreen() - mousePointOnScreen.x;
                p.y += e.getYOnScreen() - mousePointOnScreen.y;
                notepadFrame.setLocation(p);
                mousePointOnScreen = e.getLocationOnScreen();
            }
        }
    };
    private MouseAdapter justDrag = new MouseAdapter() {
        Point mousePointOnScreen;

        @Override
        public void mousePressed(MouseEvent e) {
            mousePointOnScreen = e.getLocationOnScreen();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point p = notepadFrame.getLocation();
            p.x += e.getXOnScreen() - mousePointOnScreen.x;
            p.y += e.getYOnScreen() - mousePointOnScreen.y;
            notepadFrame.setLocation(p);
            mousePointOnScreen = e.getLocationOnScreen();
        }
    };
}

