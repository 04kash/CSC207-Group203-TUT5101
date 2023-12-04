package interface_adapter.apiReturns;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ApiViewModel extends ViewModel {

    private ApiState state = new ApiState();

    /**
     * This method sets the value of the variable view name to "logged in"
     */
    public ApiViewModel() {super("logged in");}

    /**
     * This method allows us to set the value of state
     *
     * @param state is an api state that we can assign the variable state to
     */
    public void setState(ApiState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * This method informs the view that there have been changes made and that the view needs to be updated
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a {@code PropertyChangeListener} to this object's list of listeners.
     * The listener is notified whenever a bound property changes.
     *
     * @param listener the {@code PropertyChangeListener} to be added
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state of the API.
     *
     * @return the {@code ApiState} representing the current state of the API
     */
    public ApiState getState() {
        return state;
    }
}
