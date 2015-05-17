package notepad.keyTracker.Keybinds;

import SETTINGS.KEYBIND_SETTINGS;
import notepad.NotepadFrame;
import notepad.keyTracker.KeyBind;
import notepad.keyTracker.ToggleEvent;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Rafael on 5/17/2015.
 */
public class WindowDrag {
    public static final int[] dragKeys = {KEYBIND_SETTINGS.DRAG_KEY};
    private final NotepadFrame notepadFrame;
    private KeyBind keyBind;
    private boolean areKeysDown = false;

    public WindowDrag(NotepadFrame notepadFrame) {
        this.notepadFrame = notepadFrame;
        keyBind = new KeyBind(dragKeys, dragToggle);

    }
    private ToggleEvent dragToggle = new ToggleEvent() {
        @Override
        public void actionEnabled() {
            areKeysDown = true;
        }

        @Override
        public void actionDisabled() {
            areKeysDown = false;
        }
    };
    public MouseListener mouseMotionAdapter = new MouseAdapter() {
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
    public KeyBind getKeyBind(){
        return keyBind;
    }
}
