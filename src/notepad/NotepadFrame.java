package notepad;

import SETTINGS.GENERAL_SETTINGS;
import notepad.elements.NotepadMenuBar;
import notepad.keyTracker.KeyTracker;
import notepad.keyTracker.Keybinds.WindowDrag;
import notepad.textPanel.TextPanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Rafael on 5/16/2015.
 */
public class NotepadFrame extends JFrame {
    private TextPanel textPanel;
    private NotepadMenuBar notepadMenuBar;
    private KeyTracker keyTracker;


    private MouseListener mouseListener; 

    private MouseListener windowDrag;


    public NotepadFrame() {

        // JFrame Settings
        setTitle(GENERAL_SETTINGS.DISPLAY_NAME);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(500, 500);
        setUndecorated(true); //set false to put back header
        setLayout(new BorderLayout());
        setOpacity(1f);
        // GUI Contents
        createTextPanel(); 
        createJMenuBar();

        createKeyTracker();
        createMouseTracker();
    }

    private void createKeyTracker() {
        keyTracker = new KeyTracker(this);
        addKeyListener(keyTracker.keyListener);
        textPanel.textField.addKeyListener(keyTracker.keyListener);
        // create CTRL movement;
        windowDrag = new MouseAdapter() {
            Point mousePointOnScreen;

            @Override
            public void mousePressed(MouseEvent e) {
                mousePointOnScreen = e.getLocationOnScreen();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.isControlDown()) {
                    System.out.println("Dragged");
                    Point p = NotepadFrame.this.getLocation();
                    p.x += e.getXOnScreen() - mousePointOnScreen.x;
                    p.y += e.getYOnScreen() - mousePointOnScreen.y;
                    NotepadFrame.this.setLocation(p);
                    mousePointOnScreen = e.getLocationOnScreen();
                }
            }
        };
        textPanel.textField.addMouseListener(windowDrag);
    }
 
    private void createMouseTracker(){
        mouseListener = new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		// TODO Auto-generated method stub
        		super.mouseEntered(e);
        		System.out.println("Entered!");
        		changeOpacity(.5f);
        	}

			public void mouseExited(MouseEvent e) {
            	super.mouseExited(e);
                System.out.println("Exited!");
                changeOpacity(.2f);
            }
		};
       textPanel.textField.addMouseListener(mouseListener);
       //addMouseMotionListener(mouseListener);
    }


    private void changeOpacity(float opacity) {
    	setOpacity(opacity);
    }
    private void createJMenuBar(){
    	JMenu jMenu = new JMenu("View");
        notepadMenuBar = new NotepadMenuBar();
        notepadMenuBar.add(jMenu);
        add(notepadMenuBar, BorderLayout.NORTH);
    }

    private void createTextPanel() {
        textPanel = new TextPanel(); //testing
        add(textPanel, BorderLayout.CENTER);
    }
}
