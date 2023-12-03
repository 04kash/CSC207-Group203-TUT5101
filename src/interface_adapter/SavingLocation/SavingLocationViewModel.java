package interface_adapter.SavingLocation;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class specific to the saving location view.
 * This class extends the base ViewModel class and manages the state associated with the saving location functionality.
 */
public class SavingLocationViewModel extends ViewModel {
    //TODO: Figure out buttons and labels
    private SavingLocationState state = new SavingLocationState();

    /**
     * Constructs a new SavingLocationViewModel with a specific name.
     */
    public SavingLocationViewModel() {
        super("location view");
    }

    /**
     * Sets the state of the SavingLocationViewModel.
     *
     * @param state the state to set
     */
    public void setState(SavingLocationState state) {
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
     * Gets the current state associated with the saving location functionality.
     *
     * @return the SavingLocationState representing the current state
     */
    public SavingLocationState getState() {
        return state;
    }
}
