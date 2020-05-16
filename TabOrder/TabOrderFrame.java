package TabOrder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * An example of changing the taborder of a frame.
 */
public class TabOrderFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        TabOrderFrame app = new TabOrderFrame();
        CustomTabOrder tabOrder = new CustomTabOrder(app.getTabOrder());
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setFocusTraversalPolicy(tabOrder);
        app.setVisible(true);
        app.setResizable(false);
    }

    /*
     * Add all the GUI stuff here.
     */
    private static final int BORDER_SIZE = 20;
    private JButton btnA;
    private JButton btnB;
    private JButton btnC;
    private JButton btnD;

    public TabOrderFrame() {
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        //construct components
        btnA = new JButton ("A1");
        btnB = new JButton ("B2");
        btnC = new JButton ("C3");
        btnD = new JButton ("D4");

        setupButtons();
        setLayout(new BorderLayout());  
        
        add(setupHeaderPanel(), BorderLayout.NORTH);

        // add buttons to JPanel
        add(setupButtonPanel(btnA, btnB), BorderLayout.CENTER);
        add(setupButtonPanel(btnC, btnD), BorderLayout.SOUTH);
        pack();
    }

    /**
     * Set up the top panel for the app header.
     * @return
     */
    private JPanel setupHeaderPanel() {
        JPanel retPanel = new JPanel();
        JLabel lblHeader = new JLabel("<html><H1>Taborder demo</H1></html>", SwingConstants.CENTER);
        JLabel lblInstruction = new JLabel("<html><h3><i>Press Tab to cycle through the buttons.</i><h3></html>",
                SwingConstants.CENTER);
        
        retPanel.setBorder(BorderFactory.createEmptyBorder(0, BORDER_SIZE, 0, BORDER_SIZE));
        lblHeader.setBorder(BorderFactory.createEmptyBorder(0, BORDER_SIZE, 0, BORDER_SIZE));
        lblInstruction.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        retPanel.add(lblHeader);
        retPanel.add(lblInstruction);
        BoxLayout panelLayout = new BoxLayout(retPanel, BoxLayout.Y_AXIS);
        retPanel.setLayout(panelLayout);

        return retPanel;
    }

    /**
     * Create the panel to be the way we want it to be.
     */
    private JPanel setupButtonPanel(JButton btnLeft, JButton btnRight) {
        JPanel retPanel = new JPanel();
        retPanel.setBorder(BorderFactory.createEmptyBorder(0, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        retPanel.add(btnLeft, BorderLayout.WEST);
        retPanel.add(btnRight, BorderLayout.EAST);
        return retPanel;
    }

    /**
     * Set up the buttons to have good visibility on the taborder.
     */
    private void setupButtons() {
        btnA.setMnemonic('A');
        btnB.setMnemonic('B');
        btnC.setMnemonic('C');
        btnD.setMnemonic('D');
        btnA.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        btnB.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        btnC.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        btnD.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        btnA.setBackground(Color.BLACK);
        btnB.setBackground(Color.BLACK);
        btnC.setBackground(Color.BLACK);
        btnD.setBackground(Color.BLACK);
    }

    /**
     * Set the taborder to be the order you actually want it to be.
     * In this case, reverse alphabetical.
     * @return Tab order as a vector.
     */
    public Vector<Component> getTabOrder() {
        Vector<Component> retVector = new Vector<>();

        retVector.add(btnD);
        retVector.add(btnC);
        retVector.add(btnB);
        retVector.add(btnA);

        return retVector;
    }
}