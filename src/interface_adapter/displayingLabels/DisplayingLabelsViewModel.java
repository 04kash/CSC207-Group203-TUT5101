package interface_adapter.displayingLabels;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class specific to the display of labels.
 * This class extends the base ViewModel class and manages the state associated with label display.
 */
public class DisplayingLabelsViewModel extends ViewModel {

    /**
     * The state associated with the display of labels.
     */
    private DisplayingLabelsState state = new DisplayingLabelsState();

    /**
     * Constructs a new DisplayingLabelsViewModel with a specific name.
     *
     * @ param view name the name associated with the view model
     */
    public DisplayingLabelsViewModel() {
        super("planner");
    }

    /**
     * Sets the state of the DisplayingLabelsViewModel.
     *
     * @param state the state to set
     */
    public void setState(DisplayingLabelsState state) {
        this.state = state;
    }

    /**
     * PropertyChangeSupport instance to manage property change listeners.
     */
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
     * Gets the current state associated with the display of labels.
     *
     * @return the DisplayingLabelsState representing the current state
     */
    public DisplayingLabelsState getState() {
        return state;
    }
}
