package ArbitraryNumberOfPanes.PaneVariations;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Radio button. Use Combobox if selecting more than 2-3 items.
 */
public class JPanelRadioButton extends JPanelCustomBase {
    private static final long serialVersionUID = 1L;

    private String m_Name;
    private final JLabel lblField;
    private JPanel buttonPanel;
    private ArrayList<JRadioButton> m_radioButtons;
    private static final String[] defaultRadiobuttonItems = new String[] { "Item 1", "Item 2" };

    public JPanelRadioButton() {
        setPreferredSize(default_PreferredSize);
        setLayout(null);

        m_Name = null;

        lblField = new JLabel("lblField");
        add(lblField);
        lblField.setBounds(default_LabelRectangle);

        addRadioButtonsAndSetLocation(defaultRadiobuttonItems, defaultRadiobuttonItems[0]);
    }

    /**
     * Overrides constructor. Select first item in the list.
     */
    public JPanelRadioButton(final String name) {
        this(name, name, defaultRadiobuttonItems, defaultRadiobuttonItems[0]);
    }

    /**
     * Constructor.
     */
    public JPanelRadioButton(final String name, final String lableText, final String[] strOptions,
            final String selectedOption) {
        this();
        m_Name = name;
        lblField.setText(lableText);

        // Build a new list.
        addRadioButtonsAndSetLocation(strOptions, selectedOption);
    }

    /**
     * Add radio buttons to the panel, add them to the array list, group them as part of a radio button group (so only one can be selected)
     * then set the location to the default location space.
     */
    private void addRadioButtonsAndSetLocation(final String[] strOptions, final String selectedOption) {
        m_radioButtons = new ArrayList<>();
        buttonPanel = new JPanel();
        BoxLayout layout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
        buttonPanel.setLayout(layout);
        ButtonGroup rbg = new ButtonGroup();
        for(String strOption : strOptions) {
            JRadioButton rbButtonOption = new JRadioButton(strOption, strOption == selectedOption);
            m_radioButtons.add(rbButtonOption);
            buttonPanel.add(rbButtonOption);
            rbg.add(rbButtonOption);
        }
        
        add(buttonPanel);
        buttonPanel.setBounds(default_ComponentRectangle);
    }

    @Override
    public String getValue() {
        // A radio button is always selected in this case, so no need to handle the .orElse(null) scenario.
        JRadioButton selectedButton = m_radioButtons.stream()
            .filter(rb -> rb.isSelected())
            .findFirst()
            .orElse(null);
        return selectedButton.getText();
    }

    @Override
    public String getName() {
        return m_Name;
    }
}
