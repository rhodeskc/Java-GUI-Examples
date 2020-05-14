package TabOrder;

import java.awt.*;
import java.util.Vector;

/**
 * Class representing the custom tab order to use for the ComparisonToolJPanel.
 */
class CustomTabOrder extends FocusTraversalPolicy {
    private Vector<Component> m_Elements;

    /**
     * Constructor takes a list of components in the order they're to tab through.
     * Order is set by ComparisonToolJPanel.getTabOrder
     * @param items
     */
    public CustomTabOrder(Vector<Component> items) {
        m_Elements = items;
    }

    public Component getFirstComponent(Container rootContainer) {
        return !m_Elements.isEmpty() ? m_Elements.firstElement() : null;
    }

    public Component getLastComponent(Container rootContainer) {
        return !m_Elements.isEmpty() ? m_Elements.lastElement() : null;
    }

    public Component getDefaultComponent(Container rootContainer) {
        return getFirstComponent(rootContainer);
    }

    public Component getComponentAfter(Container rootContainer, Component thisComponent) {
        if(m_Elements.size() < 2) {
            return null;
        }

        int cycle_index = m_Elements.indexOf(thisComponent);
        if(cycle_index != -1) {
            int nextElementIndex = cycle_index == m_Elements.size() - 1 ? 0 : cycle_index + 1;
            return m_Elements.get(nextElementIndex);
        }

        return null;
    }

    public Component getComponentBefore(Container rootContainer, Component thisComponent) {
        if(m_Elements.size() < 2) {
            return null;
        }

        int cycle_index = m_Elements.indexOf(thisComponent);
        if(cycle_index != -1) {
            int nextElementIndex = cycle_index == 0 ? m_Elements.size() - 1 : cycle_index - 1;
            return m_Elements.get(nextElementIndex);
        }

        return null;
    }
}