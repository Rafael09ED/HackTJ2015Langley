package notepad.textPanel;

import javax.swing.*;
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
    }
}
