//package interface_adapter.DeletingLocation;
//
//import interface_adapter.ViewModel;
//
//import java.beans.PropertyChangeListener;
//import java.beans.PropertyChangeSupport;
//import java.util.ArrayList;
//
//public class DeletingLocationViewModel extends ViewModel {
//    public static final String DELETING_LOCATION_BUTTON_LABEL = "Delete";
//
//    private DeletingLocationState state = new DeletingLocationState();
//
//    public DeletingLocationViewModel() {
//        super("delete");
//    }
//
//    public void setState(DeletingLocationState state) {
//        this.state = state;
//    }
//
//    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
//
//    public void firePropertyChanged() {
//        support.firePropertyChange("state", null, this.state);
//    }
//
//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
//    }
//
//    public DeletingLocationState getState() {
//        return state;
//    }
//    public ArrayList<String> getLocation() { return state.getDeletedLocation(); }
//}
