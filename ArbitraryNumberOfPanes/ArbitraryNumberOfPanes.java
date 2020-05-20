package ArbitraryNumberOfPanes;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ArbitraryNumberOfPanes.PaneVariations.*;

/**
 * Add an arbitrary number of panes to the frame and then display it.
 */
public class ArbitraryNumberOfPanes {
    public static void main(final String[] args) {
        final int bound = 4;

        final Random rand = new Random();
        final int numberOfPanes = rand.nextInt(10) + 5;
        System.out.println("Number of panes expected: " + numberOfPanes);

        final JFrame frame = new JFrame("Arbitrary Number of Panes");
        final GridLayout layout = new GridLayout(numberOfPanes, 1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(layout);
        frame.setLocationRelativeTo(null);

        for (int i = 0; i < numberOfPanes; i++) {
            JPanelCustomBase thisComponent;
            JPanel panel;

            final int panelSelector = i % bound;
            final String lblValue = String.valueOf(i) + "_" + String.valueOf(panelSelector);

            switch (panelSelector) {
                case 0:
                    thisComponent = new JPanelTextPane(lblValue);
                    panel = thisComponent;
                    break;
                case 1:
                    thisComponent = new JPanelFileChooser(lblValue);
                    panel = thisComponent;
                    break;
                case 2:
                    thisComponent = new JPanelCombobox(lblValue);
                    panel = thisComponent;
                    break;
                case 3:
                    thisComponent = new JPanelRadioButton(lblValue);
                    panel = thisComponent;
                    break;
                default:
                    panel = null;
                    thisComponent = null;
            }

            System.out.println(lblValue + ": " + thisComponent.getValue());
            frame.getContentPane().add(panel);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
