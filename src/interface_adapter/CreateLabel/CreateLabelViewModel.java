package interface_adapter.CreateLabel;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class CreateLabelViewModel extends ViewModel {
    private CreateLabelState state = new CreateLabelState();
    public CreateLabelViewModel(){super("planner view");}
    public void setState(CreateLabelState state){
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
    public CreateLabelState getState() {
        return state;
    }
}

