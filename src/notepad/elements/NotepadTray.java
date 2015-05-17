package notepad.elements;

import SETTINGS.GENERAL_SETTINGS;
import SETTINGS.GUI_SETTINGS;
import notepad.NotepadFrame;
import notepad.dialogs.TransparencyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rafael on 5/16/2015.
 */
public class NotepadTray {
    private NotepadFrame notepadFrame;
    private PopupMenu popup;
    private static final SystemTray tray = SystemTray.getSystemTray();

    public NotepadTray(NotepadFrame notepadFrame) {
        this.notepadFrame = notepadFrame;

        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        TrayIcon trayIcon = new TrayIcon(GUI_SETTINGS.TRAY_IMAGE, GUI_SETTINGS.TRAY_NAME);
        trayIcon.setImageAutoSize(true);

        createPopupMenu();
        trayIcon.setPopupMenu(popup);

        addTrayIconToTray(trayIcon);
    }

    private static void addTrayIconToTray(TrayIcon trayIcon) {
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            e.printStackTrace();
        }
    }

    private void createPopupMenu(){
        popup = new PopupMenu("Notepad Tray Popup");
        MenuItem aboutItem = new MenuItem("About");
        MenuItem toggleShowItem = new MenuItem("Toggle Show");
        MenuItem transparencySettings= new MenuItem("Transparency Settings");
        MenuItem exitItem = new MenuItem("Exit");

        aboutItem.addActionListener(aboutAction);
        toggleShowItem.addActionListener(toggleShowAction);
        exitItem.addActionListener(closeAction);
        transparencySettings.addActionListener(transparencyAction);

        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(toggleShowItem);
        popup.add(transparencySettings);
        popup.addSeparator();
        popup.add(exitItem);

    }
    public static final ActionListener aboutAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, GENERAL_SETTINGS.ABOUT_TEXT, "About", JOptionPane.INFORMATION_MESSAGE);
        }
    };
    private ActionListener toggleShowAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (notepadFrame == null) {
                return;
            }
            notepadFrame.setVisible(!notepadFrame.isVisible());
        }
    };
    private ActionListener transparencyAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new TransparencyDialog(notepadFrame.transparencyManager);
        }
    };
    public static final ActionListener closeAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(1);
        }
    };
}
