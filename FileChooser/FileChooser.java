package FileChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Implementing two different kinds of filechoosers, one for directories and one
 * for files.
 */
public class FileChooser extends JFrame {
    public static void main(String[] args) {
        new FileChooser();
    }

    private static final String FILE_CHOOSER_APP = "File Chooser sample code.";
    private static final long serialVersionUID = 1094119068621169344L;

    private static final int BORDER_SIZE = 10;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 250;

    private JButton btnFileButton;
    private JButton btnDirectoryButton;
    private JLabel lblInstructions;
    private JLabel lblOutput;

    /**
     * Create the JPanel that handles all of the
     */
    public FileChooser() {
        JFrame thisFrame = createUI();
        addActionListeners();
        thisFrame.setLocationRelativeTo(null);
    }

    // Create the UI for the File Chooser app.
    private JFrame createUI() {
        lblInstructions = new JLabel("<html><h1>Choose a file or directory</h1></html>");
        lblOutput = new JLabel("", JLabel.CENTER);
        Border bdrLabelBorderBlue = BorderFactory.createLineBorder(Color.BLUE, 1);
        lblOutput.setBorder(bdrLabelBorderBlue);
        lblOutput.setMinimumSize(new Dimension(300, 50));

        btnFileButton = new JButton("File...");
        btnDirectoryButton = new JButton("Directory...");
        btnFileButton.setMnemonic('F');
        btnDirectoryButton.setMnemonic('D');

        // Header panel
        JPanel pnlHeader = new JPanel();
        pnlHeader.add(lblInstructions);

        // Button panel 
        JPanel pnlButtons = new JPanel();
        GridLayout glayout = new GridLayout(1, 2, BORDER_SIZE, BORDER_SIZE);
        pnlButtons.setLayout(glayout);
        pnlButtons.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        pnlButtons.add(btnFileButton, BorderLayout.WEST);
        pnlButtons.add(btnDirectoryButton);

        // Footer panel
        JPanel pnlFooter = new JPanel();
        pnlFooter.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        lblOutput.setPreferredSize(new Dimension(WINDOW_WIDTH - 40, 50));
        JScrollPane jscrollOutputPane = new JScrollPane(lblOutput, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnlFooter.add(jscrollOutputPane);

        JPanel mainPanel = new JPanel();
        mainPanel.add(pnlHeader);
        mainPanel.add(pnlButtons);
        mainPanel.add(pnlFooter);
        BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(layout);

        JFrame retFrame = new JFrame(FILE_CHOOSER_APP);
        retFrame.add(mainPanel);
        retFrame.setVisible(true);
        retFrame.setResizable(false);
        retFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        return retFrame;
    }

    /**
     * File button is clicked
     *  @param lblOutput Label to output the result to. 
     */
    private void actionFileButtonClicked(JLabel lblOutput) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Define a list of acceptable filters.
        ArrayList<FileNameExtensionFilter> listOfFilters = new ArrayList<>();
        fileChooser.setAcceptAllFileFilterUsed(true);
        listOfFilters.add(new FileNameExtensionFilter("Text Files", "txt"));
        listOfFilters.add(new FileNameExtensionFilter("Image files", "png", "jpg", "jpeg"));
        listOfFilters.add(new FileNameExtensionFilter("Excel", "xls", "xlsx", "csv"));

        for (FileNameExtensionFilter fnef : listOfFilters) {
            fileChooser.addChoosableFileFilter(fnef);
        }

        fileChooser.setCurrentDirectory(new File(getDownloadDirectory()));
        int result = fileChooser.showOpenDialog(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            lblOutput.setText(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Directory button is clicked.
     * @param lblOutput Label to output the result to. 
     */
    private void actionDirectoryButtonClicked(JLabel lblOutput) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        fileChooser.setCurrentDirectory(new File(getDownloadDirectory()));
        int result = fileChooser.showOpenDialog(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            lblOutput.setText(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Adding action listeners for the buttons.
     */
    private void addActionListeners() {
        btnDirectoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionDirectoryButtonClicked(lblOutput);
            }
        });

        btnFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionFileButtonClicked(lblOutput);
            }
        });
    }

    /**
     * Try to resolve the default download directory for the user.  This is usually %HOME%/Downloads
     * If that fails, just return the home directory.
     */
    private String getDownloadDirectory() {
        String userHome = System.getProperty("user.home");
        String testPath = Paths.get(userHome, "Downloads").toString();

        if((new File(testPath)).exists()) {
            return testPath;
        }

        return userHome;
    }
}