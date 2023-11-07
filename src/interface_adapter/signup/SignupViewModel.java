package src.interface_adapter.signup;

import java.beans.PropertyChangeListener;

public class SignupViewModel {
    private String viewName;

    public SignupViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return this.viewName;
    }
}
