package ArbitraryNumberOfPanes.PaneVariations;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Create a label and a textbox next to each other, in a way that can be repeated.
 */
public class JPanelTextPane extends JPanel implements IPanelInterface {
    private static final long serialVersionUID = 1L;
    private String m_Name;
    private final JLabel lblField;
    private final JTextField txtValue;

    public JPanelTextPane() {
        lblField = new JLabel("lblField");
        txtValue = new JTextField(250);
        m_Name = null;

        setPreferredSize(new Dimension(515, 30));
        setLayout(null);

        add(lblField);
        add(txtValue);

        lblField.setBounds(5, 2, 200, 25);
        txtValue.setBounds(210, 2, 195, 25);
    }

    /**
     * Overrides constructor.
     */
    public JPanelTextPane(final String name) {
        this(name, name, "");
    }

    /**
     * Constructor.
     */ 
    public JPanelTextPane(final String name, final String lableText, final String textFieldText) {
        this();
        m_Name = name;
        lblField.setText(lableText);
        txtValue.setText(textFieldText);
    }

    @Override
    public String getValue() {
        return txtValue.getText();
    }

    @Override
    public String getName() {
        return m_Name;
    }
}