package notepad.keyTracker;

import notepad.NotepadFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 5/16/2015.
 */
public class KeyTracker {
    //TODO:
    //Could change to hash map
    private final List<Integer> activeKeys;
    private final List<KeyBind> keyBinds;
    private KeyTracker keyTracker;

    public KeyTracker(NotepadFrame notepadFrame) {
        activeKeys = new ArrayList<>();
        keyBinds = new ArrayList<>();
        keyTracker = this;
    }

    public final KeyListener keyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (!activeKeys.contains(e.getKeyCode())) {
                activeKeys.add(e.getKeyCode());

                System.out.println("Key: " + e.getKeyCode());
                for (int i = 0; i < keyBinds.size(); i++) {
                    KeyBind keyBind = keyBinds.get(i);
                    keyBind.NewKeyPressed(keyTracker);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
             while (activeKeys.contains(e.getKeyCode())) {
                 activeKeys.remove((Object)e.getKeyCode());
             }

            for (int i = 0; i < keyBinds.size(); i++) {
                KeyBind keyBind = keyBinds.get(i);
                keyBind.KeyRemoved(keyTracker);
            }
        }
    };

    public List<Integer> getActiveKeys() {
        return activeKeys;
    }
}
