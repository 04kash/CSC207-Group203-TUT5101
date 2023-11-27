package interface_adapter.displayingLocations;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayingLocationsViewModel extends ViewModel {

    private DisplayingLocationsState state = new DisplayingLocationsState();

    public DisplayingLocationsViewModel() {super("location view");}

    public void setState(DisplayingLocationsState state) {
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

    public DisplayingLocationsState getState() {
        return state;
    }
}
