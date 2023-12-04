package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class specific to the user signup view.
 * This class extends the base ViewModel class and manages the state associated with the signup functionality.
 */
public class SignupViewModel extends ViewModel {

    private SignupState state = new SignupState();

    /**
     * Constructs a new SignupViewModel with a specific name.
     *
     * @ param view name the name associated with the view model
     */
    public SignupViewModel() {
        super("sign up");
    }

    /**
     * Sets the state of the SignupViewModel.
     *
     * @param state the state to set
     */
    public void setState(SignupState state) {
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
     * Gets the current state associated with the user signup view.
     *
     * @return the SignupState representing the current state
     */
    public SignupState getState() {
        return state;
    }
}
