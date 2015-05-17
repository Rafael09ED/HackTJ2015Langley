package notepad;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

import javax.swing.text.BadLocationException;

import javax.swing.text.Document;

import notepad.textPanel.TextField;

//created 5/16/15 by Andrew Ton

public class Saver {

	public static void save(TextField textField) {

		try {
			Document d = textField.getStyledDocument();
			File file = new File("/users/hongtran/test.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
		
			try {
				bw.write(d.getText(0, d.getLength()));
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			bw.close();

			System.out.println("saved");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
