package notepad.keyTracker;

import notepad.NotepadFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rafael on 5/16/2015.
 */
public class KeyTracker {
    //TODO:
    //Could change to hash map
    private final Set<Integer> activeKeys;
    public final List<KeyBind> keyBinds;
    private KeyTracker keyTracker;

    public KeyTracker(NotepadFrame notepadFrame) {
        activeKeys = new HashSet<>();
        keyBinds = new ArrayList<>();
        keyTracker = this;
        activeKeys.add(2);
    }

    public final KeyListener keyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (activeKeys.add(key)){

                System.out.println("Key: " + key);
                for (int i = 0; i < keyBinds.size(); i++) {
                    KeyBind keyBind = keyBinds.get(i);
                    keyBind.NewKeyPressed(keyTracker);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            while (activeKeys.contains(e.getKeyCode())) {
                activeKeys.remove(e.getKeyCode());
            }
            System.out.println("released");
            for (int i = 0; i < keyBinds.size(); i++) {
                KeyBind keyBind = keyBinds.get(i);
                keyBind.KeyRemoved(keyTracker);
            }
        }
    };

    public Set<Integer> getActiveKeys() {
        return activeKeys;
    }
}
