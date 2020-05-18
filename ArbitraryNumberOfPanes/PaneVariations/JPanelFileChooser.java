package ArbitraryNumberOfPanes.PaneVariations;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelFileChooser extends JPanel implements IPanelInterface {
    private static final long serialVersionUID = 1L;

    private String m_Name;
    private final JLabel lblField;
    private final JTextField txtValue;
    private final JButton btnChooseFile;
    private int m_choosingDirectory;

    public JPanelFileChooser() {
        lblField = new JLabel("lblField");
        txtValue = new JTextField(250);
        btnChooseFile = new JButton("Browse...");
        m_Name = null;

        btnChooseFile.setMnemonic('b');
        ;
        setPreferredSize(new Dimension(515, 30));
        setLayout(null);

        add(lblField);
        add(txtValue);
        add(btnChooseFile);

        lblField.setBounds(5, 2, 200, 25);
        txtValue.setBounds(210, 2, 195, 25);
        btnChooseFile.setBounds(410, 2, 100, 25);

        addActionListeners();
    }

    /**
     * Overrides constructor.
     */
    public JPanelFileChooser(final String name) {
        this(name, name, "", false);
    }

    /**
     * Overrides constructor.
     */
    public JPanelFileChooser(final String name, final boolean isFile) {
        this(name, name, "", isFile);
    }

    /**
     * Constructor.
     */
    public JPanelFileChooser(final String name, final String lableText, final String textFieldText, boolean isDirectory) {
        this();
        m_Name = name;
        lblField.setText(lableText);
        txtValue.setText(textFieldText);

        m_choosingDirectory = isDirectory ? JFileChooser.DIRECTORIES_ONLY : JFileChooser.FILES_ONLY;
    }

    /**
     * Browse button is clicked
     * 
     * @param txtOutput textbox to output the result to.
     */
    private void actionButtonClicked(JTextField txtOutput) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(m_choosingDirectory);
        File file = checkPossibleLocationEntered(txtOutput);

        fileChooser.setCurrentDirectory(file);
        int result = fileChooser.showOpenDialog(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            txtOutput.setText(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Check the textbox for a potential location first, if not use the default location.
     */
    private File checkPossibleLocationEntered(JTextField txtOutput) {
        File retLocation = new File(System.getProperty("user.home"));

        if (txtOutput.getText() != "") {
            File candidateLocation = new File(txtOutput.getText());

            if (candidateLocation.exists() && candidateLocation.isDirectory()) {
                retLocation = candidateLocation;
            }
        }
        return retLocation;
    }

    /**
     * Adding action listeners for the buttons.
     */
    private void addActionListeners() {
            btnChooseFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    actionButtonClicked(txtValue);
                }
            });
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