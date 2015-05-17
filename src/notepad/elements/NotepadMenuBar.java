package notepad.elements;

import notepad.NotepadFrame;
import notepad.dialogs.TransparencyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Created by Rafael on 5/16/2015.
 */
public class NotepadMenuBar extends JMenuBar {
    private final NotepadFrame notepadFrame;
    private JMenu fileMenu;
    public NotepadMenuBar(NotepadFrame notepadFrame) {
        this.notepadFrame = notepadFrame;
        createFileMenu();
        createViewMenu();
    }

    private void createViewMenu() {
        JMenu jMenu = new JMenu("View");
        jMenu.add(jMenu);
        JMenuItem jMenuItem;
        jMenuItem = new JMenuItem("Transparency Settings");
        jMenuItem.addActionListener(e -> {
            new TransparencyDialog(notepadFrame.transparencyManager);
        });
        jMenu.add(jMenuItem);

        add(jMenu);
    }

    private void createFileMenu() {
        fileMenu = new JMenu("File");
        JMenuItem TEMP_JMenuItem;

        TEMP_JMenuItem = new JMenuItem("About");
        TEMP_JMenuItem.addActionListener(NotepadTray.aboutAction);
        addToFileMenu(TEMP_JMenuItem);

        JMenuItem shortcutsItem = new JMenuItem("Keyboard Shortcuts");
        shortcutsItem.addActionListener(e -> notepadFrame.textPanel.showShortcuts());

        fileMenu.addSeparator();

        TEMP_JMenuItem = new JMenuItem("Exit");
        TEMP_JMenuItem.addActionListener(NotepadTray.closeAction);
        fileMenu.add(TEMP_JMenuItem);


        add(fileMenu);
    }
    // Use this method to add JMenuItems to the JMenu
    public void addToFileMenu(Component component){
        int fileMenuLength = fileMenu.getSubElements().length;
        System.out.println(fileMenuLength);
        if (fileMenuLength >= 1) {
            fileMenu.add(component, fileMenuLength - 1);
        } else{
            fileMenu.add(component);
        }

    }

    public void setElementsMouseListener(MouseAdapter mouseListener) {
        MenuElement[] elements = getSubElements();
        for (int i = 0; i < elements.length; i++) {
            MenuElement element = elements[i];
            element.getComponent().addMouseMotionListener(mouseListener);
        }
    }
}
