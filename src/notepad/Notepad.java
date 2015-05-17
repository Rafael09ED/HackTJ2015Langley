package notepad;

import javax.swing.*;

/**
 * Created by Rafael on 5/16/2015.
 */
public class Notepad {
    private NotepadFrame notepadFrame;

    public Notepad() {
        createNotepadGUI();
        createTrayIcon();
        notepadFrame.setVisible(true);
    }

    private void createTrayIcon() {
        new NotepadTray(notepadFrame);
    }

    private void createNotepadGUI() {
        notepadFrame = new NotepadFrame();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Notepad();
    }
}
