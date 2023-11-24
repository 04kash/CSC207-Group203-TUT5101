package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private static ViewManagerModel viewManagerModel;

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }

    public static void showSignUpView() {
        viewManagerModel.setActiveView(SignUp.viewName);
        viewManagerModel.firePropertyChanged();
    }

    public static void showSearchView() {
        viewManagerModel.setActiveView(SearchView.viewName);
        viewManagerModel.firePropertyChanged();
    }

//    public static void showPlannerView() {
//        viewManagerModel.setActiveView(PlannerView.viewName);
//        viewManagerModel.firePropertyChanged();
//    }

    public static void showLoginView() {
        viewManagerModel.setActiveView(LogInView.viewName);
        viewManagerModel.firePropertyChanged();
    }

    public static void showLoggedinView() {
        viewManagerModel.setActiveView(LoggedInView.viewName);
        viewManagerModel.firePropertyChanged();
    }
}
