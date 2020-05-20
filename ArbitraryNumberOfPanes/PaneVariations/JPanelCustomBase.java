package ArbitraryNumberOfPanes.PaneVariations;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * Set all the default sizes for the panels.
 */
public class JPanelCustomBase extends JPanel implements IPanelInterface {
    private static final long serialVersionUID = 1L;

    protected final Rectangle default_LabelRectangle = new Rectangle(5, 2, 200, 25);
    protected final Rectangle default_ComponentRectangle = new Rectangle(210, 2, 195, 25);
    protected final Rectangle default_RightSideComponent = new Rectangle(410, 2, 100, 25);

    protected final Dimension default_PreferredSize = new Dimension(515, 30);

    @Override
    public String getValue() {
        return null;
    }
}
