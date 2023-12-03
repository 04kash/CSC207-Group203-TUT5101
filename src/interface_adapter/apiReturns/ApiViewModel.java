package interface_adapter.apiReturns;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ApiViewModel extends ViewModel {

    public static final String ENTER_BUTTON_LABEL = "Enter";
    public static final String SAVED_BUTTON_LABEL = "Saved Locations";
    public static final String TITLE_LABEL = "Logged In View";
    public static final String LOCATION_LABEL = "Location";
    public static final String FILTER_LABEL = "Filter";
    public static final String PROXIMITY_LABEL = "Proximity";
    private ApiState state = new ApiState();

    public ApiViewModel() {super("logged in");}

    public void setState(ApiState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ApiState getState() {
        return state;
    }
}
