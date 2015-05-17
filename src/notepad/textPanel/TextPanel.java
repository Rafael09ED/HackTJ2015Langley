package notepad.textPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import notepad.Saver;

import java.awt.*;

/**
 * Created by Rafael on 5/16/2015.
 */
public class TextPanel extends JPanel {
    private TextField textField;
    public TextPanel() {
        setLayout(new BorderLayout(1,1));
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
			String text = "duck!";
			
			try {
				text = e.getDocument().getText(e.getLength() - 1 ,1);
				System.out.println("text: " + e.getDocument().getText(e.getLength() ,1));
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// TODO Auto-generated method stub
			if(text.equals("s")) {
				System.out.println("Success!");
				Saver.save(textField);
			}
			

		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	};
	
	
	public TextField getTextField() {
		return textField;
	}
}
