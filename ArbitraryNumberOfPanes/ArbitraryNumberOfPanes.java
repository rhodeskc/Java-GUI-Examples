package ArbitraryNumberOfPanes;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ArbitraryNumberOfPanes.PaneVariations.JPanelCombobox;
import ArbitraryNumberOfPanes.PaneVariations.JPanelFileChooser;
import ArbitraryNumberOfPanes.PaneVariations.JPanelTextPane;

/**
 * Add an arbitrary number of panes to the frame and then display it.
 */
public class ArbitraryNumberOfPanes {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberOfPanes = rand.nextInt(5) + 5;
        System.out.println("Number of panes expected: " + numberOfPanes);
                
        JFrame frame = new JFrame("Arbitrary Number of Panes");
        GridLayout layout = new GridLayout(numberOfPanes, 1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(layout);
        frame.setLocationRelativeTo(null);

        for (int i = 0; i < numberOfPanes; i++) {
            JPanel panel; 
            int randomInt = rand.nextInt(3);
            String lblValue = String.valueOf(i) + "_" + String.valueOf(randomInt);

            switch(randomInt) {
                case 0:
                    panel = new JPanelTextPane(lblValue);
                    break;
                case 1:
                    panel = new JPanelFileChooser(lblValue);
                    break;
                case 2:
                    panel = new JPanelCombobox(lblValue);
                    break;
                default:
                    panel = null;
            }

            frame.getContentPane().add(panel);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
