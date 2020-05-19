package ArbitraryNumberOfPanes.PaneVariations;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelCombobox extends JPanel implements IPanelInterface {
    private static final long serialVersionUID = 1L;

    private String m_Name;
    private final JLabel lblField;
    private final JComboBox<String> cboValue;
    private static final String[] defaultComboItems = new String[] { "Item 1", "Item 2", "Item 3" };

    public JPanelCombobox() {
        lblField = new JLabel("lblField");
        cboValue = new JComboBox<String>(defaultComboItems);
        m_Name = null;

        setPreferredSize(new Dimension(515, 30));
        setLayout(null);

        add(lblField);
        add(cboValue);

        lblField.setBounds(5, 2, 200, 25);
        cboValue.setBounds(210, 2, 195, 25);
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
