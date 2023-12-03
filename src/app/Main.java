package app;

import data_access.APIDataAccessObject;

import data_access.JsonDataAccessObject;
import data_access.OpenTripMapLocationFetcher;
import entity.CommonUserFactory;
import entity.Planner;
import interface_adapter.CreateLabel.CreateLabelViewModel;
import interface_adapter.LocationsFromLabel.LocationsFromLabelViewModel;
import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.api_returns.ApiViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Discover City");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        ApiViewModel apiViewModel = new ApiViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        DisplayingLocationsViewModel displayingLocationsViewModel = new DisplayingLocationsViewModel();
        SavingLocationViewModel savingLocationViewModel = new SavingLocationViewModel();
        LocationsFromLabelViewModel locationsFromLabelViewModel = new LocationsFromLabelViewModel();
        DisplayingLabelsViewModel displayingLabelsViewModel = new DisplayingLabelsViewModel();
        CreateLabelViewModel createLabelViewModel = new CreateLabelViewModel();

        JsonDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new JsonDataAccessObject("./users.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        APIDataAccessObject apiUserDataAccessObject;
        try {
            apiUserDataAccessObject = new APIDataAccessObject("./locations.csv", new OpenTripMapLocationFetcher());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SignUp signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LogInView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, apiViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = LoggedInUseCaseFactory.create(viewManagerModel,displayingLabelsViewModel,userDataAccessObject);
        views.add(loggedInView, loggedInView.viewName);

        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel, apiViewModel, displayingLocationsViewModel, apiUserDataAccessObject, apiUserDataAccessObject,displayingLabelsViewModel,userDataAccessObject);
        views.add(searchView, searchView.viewName);

        LocationView locationView = LocationUseCaseFactory.create(viewManagerModel, displayingLocationsViewModel, savingLocationViewModel, displayingLabelsViewModel, apiUserDataAccessObject, userDataAccessObject);
        views.add(locationView, locationView.viewName);

        PlannerView plannerView = PlannerUseCaseFactory.create(viewManagerModel, displayingLabelsViewModel, locationsFromLabelViewModel, userDataAccessObject, userDataAccessObject,createLabelViewModel,userDataAccessObject);
        views.add(plannerView, plannerView.viewName);

        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}