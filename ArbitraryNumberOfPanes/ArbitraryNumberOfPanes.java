package ArbitraryNumberOfPanes;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;

import ArbitraryNumberOfPanes.PaneVariations.JPanelTextPane;

/**
 * Add an arbitrary number of panes to the frame and then display it.
 */
public class ArbitraryNumberOfPanes {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberOfPanes = rand.nextInt(9) + 1;
        System.out.println("Number of panes expected: " + numberOfPanes);
                
        JFrame frame = new JFrame("Arbitrary Number of Panes");
        GridLayout layout = new GridLayout(numberOfPanes, 1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(layout);
        frame.setLocationRelativeTo(null);

        for (int i = 0; i < numberOfPanes; i++) {
            frame.getContentPane().add(new JPanelTextPane());
        }

        frame.pack();
        frame.setVisible(true);
    }
}