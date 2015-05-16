package notepad;

/**
 * Created by Rafael on 5/16/2015.
 */
public class Notepad {
    private NotepadFrame notepadFrame;
    public Notepad() {
        createNotepadGUI();
        notepadFrame.setVisible(true);
    }

    private void createNotepadGUI() {
        notepadFrame = new NotepadFrame();
    }

    public static void main(String[] args) { new Notepad(); }
}
