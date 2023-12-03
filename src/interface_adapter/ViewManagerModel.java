package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Model class responsible for managing the active view in the application.
 * This class tracks the active view name and provides mechanisms to update and observe changes in the active view.
 */
public class ViewManagerModel {
    private String activeViewName;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Gets the name of the currently active view.
     *
     * @return the name of the active view
     */
    public String getActiveView() {
        return activeViewName;
    }

    /**
     * Sets the name of the currently active view.
     *
     * @param activeView the name of the active view to set
     */
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    /**
     * Notifies registered property change listeners when the active view changes.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    /**
     * Adds a PropertyChangeListener to the list of listeners.
     *
     * @param listener the PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
