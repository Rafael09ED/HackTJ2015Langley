package notepad.textPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import java.awt.*;

/**
 * Created by Rafael on 5/16/2015.
 */
public class TextPanel extends JPanel {
    public TextField textField;
    
    public TextPanel() {
        setLayout(new BorderLayout(1,1));
        //setBackground(new Color(0,0,0,0)); //alter this to affect translucency
        createTextField();
    }

    private void createTextField() {
        textField = new TextField();
        add(textField, BorderLayout.CENTER);
        textField.getDocument().addDocumentListener(textFieldListener);
    }
    
    private DocumentListener textFieldListener = new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {

		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	};
}
