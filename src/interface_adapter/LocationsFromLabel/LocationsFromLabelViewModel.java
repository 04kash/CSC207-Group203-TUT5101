package interface_adapter.LocationsFromLabel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LocationsFromLabelViewModel extends ViewModel {
    private LocationsFromLabelState state = new LocationsFromLabelState();
    public LocationsFromLabelViewModel() {super("planner");}

    public void setState(LocationsFromLabelState state) {
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

    public LocationsFromLabelState getState() {
        return state;
    }
}
