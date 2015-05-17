package notepad.textPanel;

import notepad.Saver;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import notepad.Saver;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Rafael on 5/16/2015.
 */
public class TextPanel extends JPanel {
    public TextField textField;
    private static TextField textField;
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
			/*
			try {
				text = e.getDocument().getText(0 ,1);
				Document d = textField.getDocument();
				//System.out.println("text: " + d.getText(0,d.getLength()));
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// TODO Auto-generated method stub
			if(text.equals("s")) {
				System.out.println("Success!");
				Saver.save(textField);
			}
			
			if(text.equals("p")) {
				System.out.println("Success!123");
				try {
					//load();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			*/			

		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	};
	
	public static void load() throws BadLocationException, IOException {

	    File file = new File("user.dir" + "\\NotePadFile2.txt");
	    BufferedReader reader= new BufferedReader(new FileReader(file));;

	    try{
	      String line = null;
          while (!(reader.readLine()).equals(null)) {
        	  line = reader.readLine();
        	  System.out.println(line);
              textField.getDocument().insertString(0, "test", null);
          }


	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    reader.close();
	  }
	
	
	public TextField getTextField() {
		return textField;
	}
}
