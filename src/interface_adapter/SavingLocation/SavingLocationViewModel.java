package interface_adapter.SavingLocation;

import interface_adapter.ViewModel;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SavingLocationViewModel extends ViewModel {
    //TODO: Figure out buttons and labels
    private SavingLocationState state = new SavingLocationState();
    public SavingLocationViewModel(){
        super("location view");
    }
    public void setState(SavingLocationState state){
        this.state=state;
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
    public SavingLocationState getState() {
        return state;
    }
}
