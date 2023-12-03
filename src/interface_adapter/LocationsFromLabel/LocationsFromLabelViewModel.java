package interface_adapter.LocationsFromLabel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class specific to the display of locations from label.
 * This class extends the base ViewModel class and manages the state associated with location retrieval.
 */
public class LocationsFromLabelViewModel extends ViewModel {
    private LocationsFromLabelState state = new LocationsFromLabelState();

    /**
     * Constructs a new LocationsFromLabelViewModel with a specific name.
     *
     * @ param view name the name associated with the view model
     */
    public LocationsFromLabelViewModel() {
        super("planner");
    }

    /**
     * Sets the state of the LocationsFromLabelViewModel.
     *
     * @param state the state to set
     */
    public void setState(LocationsFromLabelState state) {
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
     * Gets the current state associated with the display of locations from label.
     *
     * @return the LocationsFromLabelState representing the current state
     */
    public LocationsFromLabelState getState() {
        return state;
    }
}
