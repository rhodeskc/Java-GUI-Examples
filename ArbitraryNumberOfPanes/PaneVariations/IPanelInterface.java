package ArbitraryNumberOfPanes.PaneVariations;

/**
 * All panels should use this interface to get the value from the panel.
 */
public interface IPanelInterface {
    /**
     * Get the value from this panel.
     */
    String getValue();

    /**
     * Get the name of this panel.
     */
    String getName();
}
