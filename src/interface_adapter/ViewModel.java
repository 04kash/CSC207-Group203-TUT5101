package interface_adapter;

import java.beans.PropertyChangeListener;

/**
 * Abstract class representing a ViewModel in the application's architecture.
 * A ViewModel is responsible for managing the state associated with a specific view and facilitating communication
 * between the view and the underlying business logic. This class provides a common structure for all view models.
 */
public abstract class ViewModel {
    private String viewName;

    /**
     * Constructs a new ViewModel with a specific view name.
     *
     * @param viewName the name associated with the view model
     */
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    /**
     * Gets the name associated with the view managed by this ViewModel.
     *
     * @return the view name
     */
    public String getViewName() {
        return this.viewName;
    }

    /**
     * Notifies registered property change listeners when the state of the ViewModel changes.
     * Subclasses must implement this method to define the specific behavior of property change notifications.
     */
    public abstract void firePropertyChanged();

    /**
     * Adds a PropertyChangeListener to the list of listeners.
     * Subclasses must implement this method to allow adding property change listeners.
     *
     * @param listener the PropertyChangeListener to be added
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
