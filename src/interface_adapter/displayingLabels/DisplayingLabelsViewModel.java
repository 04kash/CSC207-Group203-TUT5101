package interface_adapter.displayingLabels;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayingLabelsViewModel extends ViewModel {
    private DisplayingLabelsState state = new DisplayingLabelsState();
    public DisplayingLabelsViewModel() {super("planner");}

    public void setState(DisplayingLabelsState state) {
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

    public DisplayingLabelsState getState() {
        return state;
    }
}
