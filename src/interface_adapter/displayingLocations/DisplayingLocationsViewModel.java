package interface_adapter.displayingLocations;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class specific to the display of locations.
 * This class extends the base ViewModel class and manages the state associated with location display.
 */
public class DisplayingLocationsViewModel extends ViewModel {
    private DisplayingLocationsState state = new DisplayingLocationsState();

    /**
     * Constructs a new DisplayingLocationsViewModel with a specific name.
     *
     * @ param view name the name associated with the view model
     */
    public DisplayingLocationsViewModel() {
        super("location view");
    }

    /**
     * Sets the state of the DisplayingLocationsViewModel.
     *
     * @param state the state to set
     */
    public void setState(DisplayingLocationsState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies registered property change listeners when the state changes.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to the list of listeners.
     *
     * @param listener the PropertyChangeListener to be added
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state associated with the display of locations.
     *
     * @return the DisplayingLocationsState representing the current state
     */
    public DisplayingLocationsState getState() {
        return state;
    }
}
