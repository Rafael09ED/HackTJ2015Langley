package notepad.elements;

import notepad.NotepadFrame;

/**
 * Created by Rafael on 5/17/2015.
 */
public class TransparencyManager {
    private final NotepadFrame notepadFrame;
    private float lowOpacity = .5f;
    private float highOpacity = 1f;

    public TransparencyManager(NotepadFrame notepadFrame) {
        this.notepadFrame = notepadFrame;
    }

    public void setOpacity(float opacity){
        notepadFrame.setOpacity(opacity);
    }

    public void setLowOpacity(float lowOpacity) {
        this.lowOpacity = lowOpacity;
    }
    public void setHighOpacity(float highOpacity) {
        this.highOpacity = highOpacity;
    }

    public void setToLowOpacity() {
        notepadFrame.setOpacity(lowOpacity);
    }
    public void setToHighOpacity() {
        notepadFrame.setOpacity(highOpacity);
    }

    public float getLowTransparency() {
        return lowOpacity;
    }

    public float getHighTransparency() {
        return highOpacity;
    }
}
