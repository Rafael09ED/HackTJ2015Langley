package notepad.elements;

import notepad.NotepadTray;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rafael on 5/16/2015.
 */
public class NotepadMenuBar extends JMenuBar {
    private JMenu fileMenu;
    public NotepadMenuBar() {
        createFileMenu();
    }

    private void createFileMenu() {
        fileMenu = new JMenu("File");
        JMenuItem TEMP_JMenuItem;

        fileMenu.addSeparator();

        TEMP_JMenuItem = new JMenuItem("Exit");
        TEMP_JMenuItem.addActionListener(NotepadTray.closeAction);
        fileMenu.add(TEMP_JMenuItem);

        add(fileMenu);
    }
    // Use this method to add JMenuItems to the JMenu
    public void addToFileMenu(Component component){
        int fileMenuLength = fileMenu.getSubElements().length;
        if (fileMenuLength >= 2) {
            fileMenu.add(component, fileMenuLength - 2);
        } else{
            fileMenu.add(component);
        }

    }
}
