package notepad.transparency;

import SETTINGS.GUI_SETTINGS;
import notepad.NotepadFrame;

/**
 * Created by Rafael on 5/17/2015.
 */
public class TransparencyManager {
    private final NotepadFrame notepadFrame;
    private float lowOpacity = .5f;
    private float highOpacity = 1f;
    private final NotepadFrameFader notepadFrameFader;

    public TransparencyManager(NotepadFrame notepadFrame) {
        this.notepadFrame = notepadFrame;
        notepadFrameFader = new NotepadFrameFader(notepadFrame,  GUI_SETTINGS.OPACITY_INCREMENT, GUI_SETTINGS.ANIM_INTERVAL);
    }

    public void setOpacity(float opacity){ notepadFrameFader.setTargetOpacity(opacity); }

    public void setLowOpacity(float lowOpacity) {
        this.lowOpacity = lowOpacity;
    }
    public void setHighOpacity(float highOpacity) {
        this.highOpacity = highOpacity;
    }

    public void setToLowOpacity() { setOpacity(lowOpacity); }
    public void setToHighOpacity() {
        setOpacity(highOpacity);
    }

    public float getLowTransparency() {return lowOpacity; }
    public float getHighTransparency() { return highOpacity; }

    public void setOpacityNoFade(float opacity){
        notepadFrame.setOpacity(opacity);
    }
}
