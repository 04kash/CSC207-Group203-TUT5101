package interface_adapter.login;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class specific to the login view.
 * This class extends the base ViewModel class and manages the state associated with the login functionality.
 */
public class LoginViewModel extends ViewModel {
//    public final String TITLE_LABEL = "Log In View";
//    public final String USERNAME_LABEL = "Enter username";
//    public final String PASSWORD_LABEL = "Enter password";
//    public static final String LOGIN_BUTTON_LABEL = "Log in";
//    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private LoginState state = new LoginState();

    /**
     * Constructs a new LoginViewModel with a specific name.
     *
     * @ param view name the name associated with the view model
     */
    public LoginViewModel() {
        super("log in");
    }

    /**
     * Sets the state of the LoginViewModel.
     *
     * @param state the state to set
     */
    public void setState(LoginState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies registered property change listeners when the state changes.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to the list of listeners.
     *
     * @param listener the PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state associated with the login view.
     *
     * @return the LoginState representing the current state
     */
    public LoginState getState() {
        return state;
    }
}
