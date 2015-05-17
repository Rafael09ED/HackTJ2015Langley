package notepad.dialogs;

import notepad.elements.TransparencyManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Hashtable;

/**
 * Created by Rafael on 5/17/2015.
 */
public class TransparencyDialog {
    private final TransparencyManager transparencyManager;
    public TransparencyDialog(TransparencyManager transparencyManager) {
        this.transparencyManager = transparencyManager;
        JSlider lowTransparency = new JSlider();
        Hashtable labelTable = new Hashtable();
        labelTable.put(new Integer(0), new JLabel("0.0"));
        labelTable.put(new Integer(5), new JLabel("0.5"));
        labelTable.put(new Integer(10), new JLabel("1.0"));
        lowTransparency.setLabelTable(labelTable);
        lowTransparency.setPaintLabels(true);
        lowTransparency.setMaximum(10);
        lowTransparency.setValue((int) (10 * transparencyManager.getLowTransparency()));
        lowTransparency.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                transparencyManager.setOpacity((float)(lowTransparency.getValue() / 10.0));
            }
        });

        JSlider highTransparency = new JSlider();
        Hashtable labelTable2 = new Hashtable();
        labelTable2.put(new Integer(0), new JLabel("0.0"));
        labelTable2.put(new Integer(5), new JLabel("0.5"));
        labelTable2.put(new Integer(10), new JLabel("1.0"));
        highTransparency.setLabelTable(labelTable2);
        highTransparency.setPaintLabels(true);
        highTransparency.setMaximum(10);
        highTransparency.setValue((int) (10 * transparencyManager.getHighTransparency()));
        highTransparency.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                transparencyManager.setOpacity((float) (highTransparency.getValue() / 10.0));
            }
        });

        Object[] message = {
                "Low Transparency:", lowTransparency,
                "High Transparency:", highTransparency
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Set Transparency", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            transparencyManager.setLowOpacity((float)(lowTransparency.getValue() / 10.0));
            transparencyManager.setHighOpacity((float)(highTransparency.getValue() /10.0));

        } else {
            System.out.println("Canceled");
            transparencyManager.setToHighOpacity();
        }
    }
}
