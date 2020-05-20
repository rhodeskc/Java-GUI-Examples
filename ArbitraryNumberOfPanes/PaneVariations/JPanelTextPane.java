package ArbitraryNumberOfPanes.PaneVariations;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Create a label and a textbox next to each other, in a way that can be repeated.
 */
public class JPanelTextPane extends JPanelCustomBase {
    private static final long serialVersionUID = 1L;
    private String m_Name;
    private final JLabel lblField;
    private final JTextField txtValue;

    public JPanelTextPane() {
        lblField = new JLabel("lblField");
        txtValue = new JTextField(250);
        m_Name = null;

        setPreferredSize(default_PreferredSize);
        setLayout(null);

        add(lblField);
        add(txtValue);

        lblField.setBounds(default_LabelRectangle);
        txtValue.setBounds(default_ComponentRectangle);
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
