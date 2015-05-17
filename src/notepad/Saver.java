package notepad;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import com.sun.tools.javac.util.Paths;

import notepad.textPanel.TextField;

//created 5/16/15 by Andrew Ton

public class Saver {

	public static void save(TextField textField) {

		try {
			Document d = textField.getStyledDocument();
			File file = new File("user.dir" + "\\NotePadFile.txt");
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

	public static void load(TextField textField) throws BadLocationException, IOException {

			Document d = textField.getStyledDocument();
		    File file = new File("user.dir" + "\\NotePadFile2.rtf");
		    BufferedReader reader= new BufferedReader(new FileReader(file));;

		    try{
		      String line = null;
              while ((reader.readLine()).equals(null)) {
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
	

}
