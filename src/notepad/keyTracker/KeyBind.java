package notepad.keyTracker;

/**
 * Created by Rafael on 5/16/2015.
 */
public class KeyBind {
    private final int[] keyNumbers;
    private final ToggleEvent toggleEvent;

    public KeyBind(int[] keyNumbers, ToggleEvent toggleEvent) {
        this.keyNumbers = keyNumbers;
        this.toggleEvent = toggleEvent;
    }
    public void NewKeyPressed(KeyTracker keyTracker){
        boolean meetsRequirements = true;
        for (int i = 0; i < keyNumbers.length; i++) {
            if (!keyTracker.getActiveKeys().contains(keyNumbers[i])) {
                meetsRequirements = false;
                break;
            }

        }
        if (meetsRequirements){
            toggleEvent.actionEnabled();
        }
    }

    public void KeyRemoved(KeyTracker keyTracker) {
        toggleEvent.actionDisabled();
    }
}
