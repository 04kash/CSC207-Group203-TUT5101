package interface_adapter.CreateLabel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class specific to the creation of labels.
 * This class extends the base ViewModel class and manages the state associated with label creation.
 */
public class CreateLabelViewModel extends ViewModel {

    private CreateLabelState state = new CreateLabelState();

    /**
     * Constructs a new CreateLabelViewModel with a specific name.
     *
     * @ param view name the name associated with the view model
     */
    public CreateLabelViewModel() {
        super("planner view");
    }

    /**
     * Sets the state of the CreateLabelViewModel.
     *
     * @param state the state to set
     */
    public void setState(CreateLabelState state) {
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
     * Gets the current state associated with the creation of a label.
     *
     * @return the CreateLabelState representing the current state
     */
    public CreateLabelState getState() {
        return state;
    }
}
