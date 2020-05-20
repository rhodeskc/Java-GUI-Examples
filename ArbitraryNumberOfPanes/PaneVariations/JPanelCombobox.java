package ArbitraryNumberOfPanes.PaneVariations;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class JPanelCombobox extends JPanelCustomBase {
    private static final long serialVersionUID = 1L;

    private String m_Name;
    private final JLabel lblField;
    private final JComboBox<String> cboValue;
    private static final String[] defaultComboItems = new String[] { "Item 1", "Item 2", "Item 3" };

    public JPanelCombobox() {
        lblField = new JLabel("lblField");
        cboValue = new JComboBox<String>(defaultComboItems);
        m_Name = null;

        setPreferredSize(default_PreferredSize);
        setLayout(null);

        add(lblField);
        add(cboValue);

        lblField.setBounds(default_LabelRectangle);
        cboValue.setBounds(default_ComponentRectangle);
    }

    /**
     * Overrides constructor.  Select first item in the list.
     */
    public JPanelCombobox(final String name) {
        this(name, name, defaultComboItems, defaultComboItems[0]);
    }

    /**
     * Constructor.
     */
    public JPanelCombobox(final String name, final String lableText, final String[] strOptions, final String selectedOption) {
        this();
        m_Name = name;
        lblField.setText(lableText);

        cboValue.removeAllItems();
        for(final String s : strOptions) {
            cboValue.addItem(s);
        }

        cboValue.setSelectedItem(selectedOption);
    }

    @Override
    public String getValue() {
        return cboValue.getSelectedItem().toString();
    }

    @Override
    public String getName() {
        return m_Name;
    }
}
